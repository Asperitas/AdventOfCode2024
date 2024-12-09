package twentytwentyfour.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Puzzle1Test {

    @Test
    void testPuzzle1() {
        String diskMap = "2333133121414131402";

        assertEquals(1928, new Day09Puzzle1(diskMap).solve());
    }
}
