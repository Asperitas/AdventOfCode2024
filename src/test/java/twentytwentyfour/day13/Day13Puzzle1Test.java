package twentytwentyfour.day13;

import org.junit.jupiter.api.Test;
import twentytwentyfour.day13.data.PuzzleInput;

import java.awt.Point;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<PuzzleInput> inputs = List.of(
                new PuzzleInput(new Point(94, 34), new Point(22, 67), new Point(8400, 5400)),
                new PuzzleInput(new Point(26, 66), new Point(67, 21), new Point(12748, 12176)),
                new PuzzleInput(new Point(17, 86), new Point(84, 37), new Point(7870, 6450)),
                new PuzzleInput(new Point(69, 23), new Point(27, 71), new Point(18641, 10279))
        );

        assertEquals(480, new Day13Puzzle1(inputs).solve());
    }

}
