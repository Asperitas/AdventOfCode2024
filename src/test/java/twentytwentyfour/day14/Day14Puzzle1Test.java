package twentytwentyfour.day14;

import org.junit.jupiter.api.Test;
import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day14.data.Robot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<Robot> robots = List.of(
                new Robot(new Point(0, 4), new Point(3, -3)),
                new Robot(new Point(6, 3), new Point(-1, -3)),
                new Robot(new Point(10, 3), new Point(-1, 2)),
                new Robot(new Point(2, 0), new Point(2, -1)),
                new Robot(new Point(0, 0), new Point(1, 3)),
                new Robot(new Point(3, 0), new Point(-2, -2)),
                new Robot(new Point(7, 6), new Point(-1, -3)),
                new Robot(new Point(3, 0), new Point(-1, -2)),
                new Robot(new Point(9, 3), new Point(2, 3)),
                new Robot(new Point(7, 3), new Point(-1, 2)),
                new Robot(new Point(2, 4), new Point(2, -3)),
                new Robot(new Point(9, 5), new Point(-3, -3))
        );

        assertEquals(12, new Day14Puzzle1(robots, 11, 7).solve());
    }

}
