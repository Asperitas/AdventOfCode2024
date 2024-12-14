package twentytwentyfour.day14;

import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day14.data.Robot;
import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day14InputReader implements LineHandler {
    private final List<Robot> robots = new ArrayList<>();

    public Day14InputReader() {
        InputReader.read("day14-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        String[] split = line.split(" ");

        robots.add(new Robot(makePointFromLineSegment(split[0]), makePointFromLineSegment(split[1])));
    }

    public List<Robot> getRobots() {
        return robots;
    }

    private Point makePointFromLineSegment(String lineSegment) {
        String[] pointString = lineSegment.substring(2).split(",");

        return new Point(Integer.parseInt(pointString[0]), Integer.parseInt(pointString[1]));
    }
}
