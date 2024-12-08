package twentytwentyfour.day08;

import twentytwentyfour.Solution;
import twentytwentyfour.day08.data.LineUtils;
import twentytwentyfour.day08.data.RoofPosition;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day08Puzzle1 implements Solution {

    private final List<List<RoofPosition>> roof;

    public Day08Puzzle1(List<List<RoofPosition>> roof) {
        this.roof = roof;
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        createAntennaMap()
                .values()
                .forEach(this::projectAntinodes);

        return roof.stream()
                .flatMap(Collection::stream)
                .filter(RoofPosition::isAntinode)
                .count();
    }

    private Map<Character, List<Point>> createAntennaMap() {
        Map<Character, List<Point>> antennaMap = new HashMap<>();

        for (int y = 0; y < roof.size(); y++) {
            for (int x = 0; x < roof.get(y).size(); x++) {
                RoofPosition roofPosition = roof.get(y).get(x);
                if (roofPosition.isAntenna()) {
                    antennaMap.putIfAbsent(roofPosition.getFrequency(), new ArrayList<>());
                    antennaMap.get(roofPosition.getFrequency()).add(new Point(x, y));
                }
            }
        }

        return antennaMap;
    }

    private void projectAntinodes(List<Point> antennas) {
        if (antennas.size() <= 1) {
            return;
        }

        Point firstAntenna = antennas.get(0);
        List<Point> otherAntennas = antennas.stream().skip(1).toList();

        otherAntennas.forEach(secondAntenna -> projectAntinodes(firstAntenna, secondAntenna));
        projectAntinodes(otherAntennas);
    }

    private void projectAntinodes(Point antenna1, Point antenna2) {
        int xDiff = LineUtils.findXDiff(antenna1, antenna2);
        int yDiff = LineUtils.findYDiff(antenna1, antenna2);
        int direction = LineUtils.findDirection(antenna1, antenna2);

        projectAntinode(new Point(antenna1.x - xDiff * direction, antenna1.y - yDiff));
        projectAntinode(new Point(antenna2.x + xDiff * direction, antenna2.y + yDiff));
    }

    private void projectAntinode(Point antinode) {
        if (!isInBounds(antinode)) {
            return;
        }

        roof.get(antinode.y).get(antinode.x).markAsAntinode();
    }

    private boolean isInBounds(Point p) {
        return isInBounds(p.x, p.y);
    }

    private boolean isInBounds(int x, int y) {
        return y >= 0 && y < roof.size()
                && x >= 0 && x < roof.get(0).size();
    }
}
