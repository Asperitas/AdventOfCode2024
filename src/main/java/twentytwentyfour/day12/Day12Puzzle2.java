package twentytwentyfour.day12;

import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day12Puzzle2 extends Day12Puzzle1 {

    public Day12Puzzle2(List<List<Character>> gardenPlots) {
        super(gardenPlots);
    }

    @Override
    public long solve() {
        long costs = 0;

        Point plotLocation = findFirstUnmarkedPlot();
        while (plotLocation != null) {
            Set<Point> area = mapArea(plotLocation);

            costs += area.size() * countSides(area);

            plotLocation = findFirstUnmarkedPlot();
        }

        return costs;
    }

    private Set<Point> mapArea(Point startingPosition) {
        markPlot(startingPosition);

        Set<Point> area = new HashSet<>();
        area.add(startingPosition);
        char plot = getPlot(startingPosition);

        findAdjacentPlots(startingPosition)
                .stream()
                .filter(position -> isInBounds(position) && !isPlotMarked(position) && getPlot(position) == plot)
                .map(this::mapArea)
                .flatMap(Collection::stream)
                .forEach(area::add);

        return area;
    }

    private static long countSides(Set<Point> area) {
        long sideCount = 0;

        for (Point p : area) {
            if (isTopLeftOutsideCorner(p, area) || isTopLeftInsideCorner(p, area)) {
                sideCount++;
            }
            
            if (isTopRightOutsideCorner(p, area) || isTopRightInsideCorner(p, area)) {
                sideCount++;
            }
            
            if (isBottomRightOutsideCorner(p, area) || isBottomRightInsideCorner(p, area)) {
                sideCount++;
            }
            
            if (isBottomLeftOutsideCorner(p, area) || isBottomLeftInsideCorner(p, area)) {
                sideCount++;
            }
        }

        return sideCount;
    }

    private static boolean isTopLeftOutsideCorner(Point p, Set<Point> area) {
        return !hasLeftNeighbour(p, area) && !hasTopNeighbour(p, area);
    }

    private static boolean isTopLeftInsideCorner(Point p, Set<Point> area) {
        return hasLeftNeighbour(p, area) && hasTopNeighbour(p, area) && !hasTopLeftNeighbour(p, area);
    }

    private static boolean isTopRightOutsideCorner(Point p, Set<Point> area) {
        return !hasRightNeighbour(p, area) && !hasTopNeighbour(p, area);
    }

    private static boolean isTopRightInsideCorner(Point p, Set<Point> area) {
        return hasRightNeighbour(p, area) && hasTopNeighbour(p, area) && !hasTopRightNeighbour(p, area);
    }

    private static boolean isBottomLeftOutsideCorner(Point p, Set<Point> area) {
        return !hasLeftNeighbour(p, area) && !hasBottomNeighbour(p, area);
    }

    private static boolean isBottomLeftInsideCorner(Point p, Set<Point> area) {
        return hasLeftNeighbour(p, area) && hasBottomNeighbour(p, area) && !hasBottomLeftNeighbour(p, area);
    }

    private static boolean isBottomRightOutsideCorner(Point p, Set<Point> area) {
        return !hasRightNeighbour(p, area) && !hasBottomNeighbour(p, area);
    }

    private static boolean hasTopLeftNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x - 1, p.y - 1));
    }

    private static boolean hasLeftNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x - 1, p.y));
    }

    private static boolean hasRightNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x + 1, p.y));
    }

    private static boolean hasTopNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x, p.y - 1));
    }

    private static boolean hasBottomNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x, p.y + 1));
    }

    private static boolean hasTopRightNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x + 1, p.y - 1));
    }

    private static boolean isBottomRightInsideCorner(Point p, Set<Point> area) {
        return hasRightNeighbour(p, area) && hasBottomNeighbour(p, area) && !hasBottomRightNeighbour(p, area);
    }

    private static boolean hasBottomLeftNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x - 1, p.y + 1));
    }

    private static boolean hasBottomRightNeighbour(Point p, Set<Point> area) {
        return area.contains(new Point(p.x + 1, p.y + 1));
    }
}
