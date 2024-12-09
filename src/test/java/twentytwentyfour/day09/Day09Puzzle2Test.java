package twentytwentyfour.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Puzzle2Test {

    @Test
    void testPuzzle2() {
        String diskMap = "2333133121414131402";

        assertEquals(2858, new Day09Puzzle2(diskMap).solve());
    }
}
