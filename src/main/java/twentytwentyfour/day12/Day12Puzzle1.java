package twentytwentyfour.day12;

import twentytwentyfour.Solution;
import twentytwentyfour.day12.data.RegionStats;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day12Puzzle1 implements Solution {
    private final List<List<Character>> gardenPlots;
    private final List<List<Boolean>> markedPlots;

    private int lastRow = 0;

    public Day12Puzzle1(List<List<Character>> gardenPlots) {
        this.gardenPlots = gardenPlots;
        this.markedPlots = gardenPlots.stream()
                .map(row -> row.stream().map(plot -> false).collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        long costs = 0;

        Point plotLocation = findFirstUnmarkedPlot();
        while (plotLocation != null) {
            RegionStats stats = mapRegion(plotLocation, getPlot(plotLocation));
            costs += stats.getBoundaries() * stats.getArea();

            plotLocation = findFirstUnmarkedPlot();
        }

        return costs;
    }

    private RegionStats mapRegion(Point plotLocation, char regionPlot) {
        markPlot(plotLocation);

        List<Point> adjacentPlotLocations = findAdjacentPlots(plotLocation);

        RegionStats stats = RegionStats.of(getStatsForAdjacentRegionPlots(regionPlot, adjacentPlotLocations));

        stats.addBoundaries(countBoundaries(regionPlot, adjacentPlotLocations));
        stats.addPlotToArea();

        return stats;
    }

    private static List<Point> findAdjacentPlots(Point plotLocation) {
        return List.of(
                new Point(plotLocation.x - 1, plotLocation.y), // top
                new Point(plotLocation.x + 1, plotLocation.y), // bottom
                new Point(plotLocation.x, plotLocation.y - 1), // left
                new Point(plotLocation.x, plotLocation.y + 1)  // right
        );
    }

    private long countBoundaries(char regionPlot, List<Point> adjacentPlotLocations) {
        return adjacentPlotLocations.stream()
                .filter(location -> !isInBounds(location) || getPlot(location) != regionPlot)
                .count();
    }

    private List<RegionStats> getStatsForAdjacentRegionPlots(char regionPlot, List<Point> adjacentPlotLocations) {
        return adjacentPlotLocations.stream()
                .filter(location -> isInBounds(location) && !isPlotMarked(location) && getPlot(location) == regionPlot)
                .map(location -> mapRegion(location, regionPlot))
                .toList();
    }

    private Point findFirstUnmarkedPlot() {
        for (int y = lastRow; y < markedPlots.size(); y++) {
            int x = markedPlots.get(y).indexOf(false);
            if (x != -1) {
                lastRow = y;
                return new Point(x, y);
            }
        }

        return null;
    }

    private boolean isInBounds(Point location) {
        return location.y >= 0 && location.y < gardenPlots.size()
                && location.x >= 0 && location.x < gardenPlots.getFirst().size();
    }

    private char getPlot(Point location) {
        return gardenPlots.get(location.y).get(location.x);
    }

    private void markPlot(Point location) {
        markedPlots.get(location.y).set(location.x, true);
    }

    private boolean isPlotMarked(Point location) {
        return markedPlots.get(location.y).get(location.x);
    }
}
