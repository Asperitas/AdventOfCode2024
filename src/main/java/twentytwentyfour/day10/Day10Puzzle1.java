package twentytwentyfour.day10;

import twentytwentyfour.Solution;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day10Puzzle1 implements Solution {
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 9;

    private final List<List<Integer>> topographicMap;

    private List<Point> startingPoints;
    private int scores = 0;

    public Day10Puzzle1(List<List<Integer>> topographicMap) {
        this.topographicMap = topographicMap;
        findStartingPoints();
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public int solve() {
        scores = 0;

        startingPoints.forEach(position -> findNextStep(position, new ArrayList<>()));

        return scores;
    }

    private void findNextStep(Point position, List<Point> endsReached) {
        int currentHeight = topographicMap.get(position.y).get(position.x);
        int nextHeight = currentHeight + 1;

        getAdjacentPositions(position)
                .filter(nextPosition -> getHeight(nextPosition) == nextHeight)
                .forEach(nextPosition -> {
                    if (nextHeight == MAX_HEIGHT && !endsReached.contains(nextPosition)) {
                        scores++;
                        endsReached.add(nextPosition);
                        return;
                    }

                    findNextStep(nextPosition, endsReached);
                });
    }

    private Stream<Point> getAdjacentPositions(Point position) {
        return Stream.of(
                new Point(position.x, position.y - 1), // top
                new Point(position.x, position.y + 1), // bottom
                new Point(position.x - 1, position.y), // left
                new Point(position.x + 1, position.y)  // right
        ).filter(this::isInBounds);
    }

    private boolean isInBounds(Point position) {
        return position.x >= 0 && position.x < topographicMap.getFirst().size()
                && position.y >= 0 && position.y < topographicMap.size();
    }

    private int getHeight(Point position) {
        return topographicMap.get(position.y).get(position.x);
    }

    private void findStartingPoints() {
        startingPoints = new ArrayList<>();

        for (int y = 0; y < topographicMap.size(); y++) {
            for (int x = 0; x < topographicMap.get(y).size(); x++) {
                if (topographicMap.get(y).get(x) == MIN_HEIGHT) {
                    startingPoints.add(new Point(x, y));
                }
            }
        }
    }
}
