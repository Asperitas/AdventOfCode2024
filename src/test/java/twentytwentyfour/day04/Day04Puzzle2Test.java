package twentytwentyfour.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Puzzle2Test {

    @Test
    void testPuzzle2() {
        String[] input = {
                "MMMSXXMASM", // 0
                "MSAMXMSMSA", // 1
                "AMXSXMAAMM", // 2
                "MSAMASMSMX", // 3
                "XMASAMXAMM", // 4
                "XXAMMXXAMA", // 5
                "SMSMSASXSS", // 6
                "SAXAMASAAA", // 7
                "MAMMMXMMMM", // 8
                "MXMXAXMASX"  // 9
        };

        Day04Puzzle2 puzzle = new Day04Puzzle2(input);
        assertEquals(9, puzzle.solve());
    }

}
