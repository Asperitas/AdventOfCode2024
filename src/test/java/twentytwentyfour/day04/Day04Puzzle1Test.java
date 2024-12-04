package twentytwentyfour.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Puzzle1Test {

    @Test
    void testPuzzle1() {
        String[] input = {
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        };

        Day04Puzzle1 puzzle1 = new Day04Puzzle1(input);

        // Horizontal: 5
        // Vertical: 3
        // Diagonal: 10
        assertEquals(18, puzzle1.countWordOccurrences());
    }

}
