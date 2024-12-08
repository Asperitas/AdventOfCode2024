package twentytwentyfour.day08;

import twentytwentyfour.day08.data.LineUtils;
import twentytwentyfour.day08.data.RoofPosition;

import java.awt.Point;
import java.util.List;

public class Day08Puzzle2 extends Day08Puzzle1 {

    public Day08Puzzle2(List<List<RoofPosition>> roof) {
        super(roof);
    }

    @Override
    protected void projectAntinodes(Point antenna1, Point antenna2) {
        int xDiff = LineUtils.findXDiff(antenna1, antenna2);
        int yDiff = LineUtils.findYDiff(antenna1, antenna2);
        int direction = LineUtils.findDirection(antenna1, antenna2);

        int newX = antenna1.x - xDiff * direction;
        int newY = antenna1.y - yDiff;

        // Also mark current antennas as antinodes
        projectAntinode(antenna1);
        projectAntinode(antenna2);

        while (isInBounds(newX, newY)) {
            projectAntinode(new Point(newX, newY));

            newX = newX - xDiff * direction;
            newY = newY - yDiff;
        }

        int newX2 = antenna2.x + xDiff * direction;
        int newY2 = antenna2.y + yDiff;

        while (isInBounds(newX2, newY2)) {
            projectAntinode(new Point(newX2, newY2));

            newX2 = newX2 + xDiff * direction;
            newY2 = newY2 + yDiff;
        }
    }
}
