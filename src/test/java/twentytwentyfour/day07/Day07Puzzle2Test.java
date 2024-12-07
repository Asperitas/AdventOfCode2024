package twentytwentyfour.day07;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Puzzle2Test {

    @Test
    void testPuzzle2() {
        Map<Long, List<List<Long>>> equations = Map.of(
                190L, List.of(List.of(10L, 19L)),
                3267L, List.of(List.of(81L, 40L, 27L)),
                83L, List.of(List.of(17L, 5L)),
                156L, List.of(List.of(15L, 6L)),
                7290L, List.of(List.of(6L, 8L, 6L, 15L)),
                161011L, List.of(List.of(16L, 10L, 13L)),
                192L, List.of(List.of(17L, 8L, 14L)),
                21037L, List.of(List.of(9L, 7L, 18L, 13L)),
                292L, List.of(List.of(11L, 6L, 16L, 20L))
        );

        assertEquals(11387, new Day07Puzzle2(equations).solve());
    }
}
