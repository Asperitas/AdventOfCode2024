package twentytwentyfour.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<List<Integer>> input = List.of(
                List.of(8, 9, 0, 1, 0, 1, 2, 3),
                List.of(7, 8, 1, 2, 1, 8, 7, 4),
                List.of(8, 7, 4, 3, 0, 9, 6, 5),
                List.of(9, 6, 5, 4, 9, 8, 7, 4),
                List.of(4, 5, 6, 7, 8, 9, 0, 3),
                List.of(3, 2, 0, 1, 9, 0, 1, 2),
                List.of(0, 1, 3, 2, 9, 8, 0, 1),
                List.of(1, 0, 4, 5, 6, 7, 3, 2)
        );

         assertEquals(36, new Day10Puzzle1(input).solve());
    }
}
