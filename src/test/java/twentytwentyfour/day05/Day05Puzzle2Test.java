package twentytwentyfour.day05;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Puzzle2Test {

    @Test
    void testPuzzle2() {
        Map<Integer, List<Integer>> orderingRules = Map.of(
                29, List.of(13),
                47, List.of(13, 29, 53, 61),
                53, List.of(13, 29),
                61, List.of(13, 29, 53),
                75, List.of(13, 29, 47, 53, 61),
                97, List.of(13, 29, 47, 53, 61, 75)
        );

        List<List<Integer>> pageNumbers = List.of(
                List.of(75, 47, 61, 53, 29),
                List.of(97, 61, 53, 29, 13),
                List.of(75, 29, 13),
                List.of(75, 97, 47, 61, 53),
                List.of(61, 13, 29),
                List.of(97, 13, 75, 29, 47)
        );

        assertEquals(123, new Day05Puzzle2(orderingRules, pageNumbers).solve());
    }
}
