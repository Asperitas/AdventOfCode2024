package twentytwentyfour.day14;

import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day14.data.Robot;

import java.util.List;

public class Day14Puzzle2 extends Day14Puzzle1 {

    public Day14Puzzle2(List<Robot> robots, int xBoundary, int yBoundary) {
        super(robots, xBoundary, yBoundary);
    }

    @Override
    public long solve() {
        long seconds = 0;

        while (!isEachRobotAtDifferentPosition()) {
            moveRobots();
            seconds++;
        }

        return seconds;
    }

    @Override
    protected void moveRobots() {
        robots.forEach(robot -> robot.move(xBoundary, yBoundary));
    }

    private boolean isEachRobotAtDifferentPosition() {
        long uniquePositions = robots.stream()
                .map(Robot::getPosition)
                .distinct()
                .count();

        return uniquePositions == robots.size();
    }

    private void printPositions() {
        for (int y = 0; y < yBoundary; y++) {
            StringBuilder output = new StringBuilder();
            for (int x = 0; x < xBoundary; x++) {
                output.append(createPositionString(new Point(x, y)));
            }

            System.out.println(output);
        }
        System.out.println();
    }

    private String createPositionString(Point position) {
        boolean robotAtPosition = robots.stream()
                .anyMatch(robot -> robot.isAtPosition(position));

        return robotAtPosition ? "#" : ".";
    }
}
