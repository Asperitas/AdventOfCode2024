package twentytwentyfour.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<Long> stones = List.of(125L, 17L);

        assertEquals(55312, new Day11Puzzle1(stones).solve());
    }

}
