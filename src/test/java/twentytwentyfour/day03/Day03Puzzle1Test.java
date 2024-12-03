package twentytwentyfour.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Puzzle1Test {
    @Test
    void multiplyFromCorruptedMemory_ShouldFindValidInstructionsInCorruptedMemory() {
        String corruptedMemory = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        assertEquals(161, Day03Puzzle1.multiplyFromCorruptedMemory(corruptedMemory));
    }
}
