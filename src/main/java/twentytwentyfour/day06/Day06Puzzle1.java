package twentytwentyfour.day06;

import twentytwentyfour.Solution;
import twentytwentyfour.day06.data.Direction;
import twentytwentyfour.day06.data.Guard;
import twentytwentyfour.day06.data.MapPosition;

import java.awt.Point;
import java.util.Collection;
import java.util.List;

public class Day06Puzzle1 implements Solution {

    protected Guard guard;
    protected final List<List<MapPosition>> map;

    protected boolean endReached = false;

    public Day06Puzzle1(Guard guard, List<List<MapPosition>> map) {
        this.guard = guard;
        this.map = map;
    }

    public Day06Puzzle1(Day06InputReader inputReader) {
        this.guard = inputReader.getGuard();
        this.map = inputReader.getMap();
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        while (!endReached) {
            moveGuard();
        }

        return map.stream()
                .flatMap(Collection::stream)
                .filter(MapPosition::isVisited)
                .count();
    }

    protected void moveGuard() {
        Point nextPosition = determineNextPosition(guard.getDirection());

        map.get(guard.getPosition().y).get(guard.getPosition().x).markAsVisited();

        if (!isInBounds(nextPosition)) {
            endReached = true;
            return;
        }

        if (isObstacle(nextPosition)) {
            guard.turnRight();
            return;
        }

        guard.setPosition(nextPosition);
    }

    protected Point determineNextPosition(Direction direction) {
        Point nextLocation = new Point(guard.getPosition().x, guard.getPosition().y);

        if (direction == Direction.UP) {
            nextLocation.y--;
        }
        if (direction == Direction.DOWN) {
            nextLocation.y++;
        }
        if (direction == Direction.LEFT) {
            nextLocation.x--;
        }
        if (direction == Direction.RIGHT) {
            nextLocation.x++;
        }

        return nextLocation;
    }

    protected boolean isInBounds(Point p) {
        return p.x >= 0 && p.x < map.get(0).size()
                && p.y >= 0 && p.y < map.size();
    }

    protected boolean isObstacle(Point p) {
        return map.get(p.y).get(p.x).isObstacle();
    }
}
