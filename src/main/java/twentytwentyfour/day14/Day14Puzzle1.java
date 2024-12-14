package twentytwentyfour.day14;

import twentytwentyfour.Solution;
import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day14.data.Quadrant;
import twentytwentyfour.day14.data.Robot;

import java.util.List;

public class Day14Puzzle1 implements Solution {

    private final List<Robot> robots;
    private final int xBoundary;
    private final int yBoundary;
    private final Point center;

    public Day14Puzzle1(List<Robot> robots, int xBoundary, int yBoundary) {
        this.robots = robots;
        this.xBoundary = xBoundary;
        this.yBoundary = yBoundary;
        this.center = new Point (xBoundary / 2, yBoundary / 2);
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        moveRobots();

        return determineSafetyFactor();
    }

    private long determineSafetyFactor() {
        return countRobotsInQuadrant(Quadrant.TOP_LEFT)
                * countRobotsInQuadrant(Quadrant.TOP_RIGHT)
                * countRobotsInQuadrant(Quadrant.BOTTOM_LEFT)
                * countRobotsInQuadrant(Quadrant.BOTTOM_RIGHT);
    }

    private void moveRobots() {
        for (int seconds = 0; seconds < 100; seconds++) {
            robots.forEach(robot -> robot.move(xBoundary, yBoundary));
        }
    }

    private long countRobotsInQuadrant(Quadrant quadrant) {
        return robots.stream()
                .filter(robot -> robot.isInQuadrant(center, quadrant))
                .count();
    }
}
