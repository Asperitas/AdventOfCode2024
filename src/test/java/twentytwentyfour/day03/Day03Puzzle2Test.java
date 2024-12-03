package twentytwentyfour.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day03Puzzle2Test {
    @Test
    void multiplyFromCorruptedMemory_ShouldFindValidInstructionsInCorruptedMemory() {
        String corruptedMemory = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

        assertEquals(48, new Day03Puzzle2().multiplyFromCorruptedMemory(corruptedMemory));
    }
}
