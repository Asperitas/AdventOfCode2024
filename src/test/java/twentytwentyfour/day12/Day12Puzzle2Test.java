package twentytwentyfour.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Puzzle2Test {

    @Test
    void testPuzzle2() {
        List<List<Character>> gardenPlots = List.of(
                List.of('R', 'R', 'R', 'R', 'I', 'I', 'C', 'C', 'F', 'F'),
                List.of('R', 'R', 'R', 'R', 'I', 'I', 'C', 'C', 'C', 'F'),
                List.of('V', 'V', 'R', 'R', 'R', 'C', 'C', 'F', 'F', 'F'),
                List.of('V', 'V', 'R', 'C', 'C', 'C', 'J', 'F', 'F', 'F'),
                List.of('V', 'V', 'V', 'V', 'C', 'J', 'J', 'C', 'F', 'E'),
                List.of('V', 'V', 'I', 'V', 'C', 'C', 'J', 'J', 'E', 'E'),
                List.of('V', 'V', 'I', 'I', 'I', 'C', 'J', 'J', 'E', 'E'),
                List.of('M', 'I', 'I', 'I', 'I', 'I', 'J', 'J', 'E', 'E'),
                List.of('M', 'I', 'I', 'I', 'S', 'I', 'J', 'E', 'E', 'E'),
                List.of('M', 'M', 'M', 'I', 'S', 'S', 'J', 'E', 'E', 'E')
        );

        assertEquals(1206, new Day12Puzzle2(gardenPlots).solve());
    }
}
