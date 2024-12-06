package twentytwentyfour.day06;

import twentytwentyfour.day06.data.Direction;
import twentytwentyfour.day06.data.Guard;
import twentytwentyfour.day06.data.MapPosition;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06Puzzle2 extends Day06Puzzle1 {
    Map<Point, List<Direction>> visitedPositions = new HashMap<>();

    private int loopCount = 0;

    public Day06Puzzle2(Guard guard, List<List<MapPosition>> map) {
        super(guard, map);
    }

    public Day06Puzzle2(Day06InputReader inputReader) {
        super(inputReader);
    }

    @Override
    public long solve() {
        Point guardDefaultPosition = guard.getPosition();
        Direction guardDefaultDirection = guard.getDirection();

        // Determine guard's path
        while (!endReached) {
            moveGuard();
        }

        map.stream()
                .flatMap(Collection::stream)
                .filter(MapPosition::isVisited)
                .forEach(position -> testCourseWithObstruction(
                        position,
                        new Guard(guardDefaultPosition, guardDefaultDirection)
                ));

        return loopCount;
    }

    private void testCourseWithObstruction(MapPosition visitedPosition, Guard newGuard) {
        visitedPosition.markAsObstructed();
        guard = newGuard;
        endReached = false;
        visitedPositions = new HashMap<>();

        while (!endReached && !isInLoop()) {
            moveGuardWithObstactles();
        }

        if (isInLoop()) {
            loopCount++;
        }

        visitedPosition.markAsVisited();
    }

    protected void moveGuardWithObstactles() {
        Point nextPosition = determineNextPosition(guard.getDirection());
        Point currentPosition = guard.getPosition();

        if (!isInBounds(nextPosition)) {
            endReached = true;
            return;
        }

        if (isObstacle(nextPosition)) {
            guard.turnRight();
            return;
        }

        visitedPositions.putIfAbsent(currentPosition, new ArrayList<>());
        visitedPositions.get(currentPosition).add(guard.getDirection());

        guard.setPosition(nextPosition);
    }

    private boolean isInLoop() {
        return visitedPositions.containsKey(guard.getPosition())
                && visitedPositions.get(guard.getPosition()).contains(guard.getDirection());
    }
}
