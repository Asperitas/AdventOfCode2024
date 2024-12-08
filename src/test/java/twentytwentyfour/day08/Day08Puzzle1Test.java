package twentytwentyfour.day08;

import org.junit.jupiter.api.Test;
import twentytwentyfour.day08.data.RoofPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<List<RoofPosition>> roof = List.of(
                createLine(null, null),
                createLine('0', 8),
                createLine('0', 5),
                createLine('0', 7),
                createLine('0', 4),
                createLine('A', 6),
                createLine(null, null),
                createLine(null, null),
                createLine('A', 8),
                createLine('A', 9),
                createLine(null, null),
                createLine(null, null)
        );

        assertEquals(14, new Day08Puzzle1(roof).solve());
    }

    private List<RoofPosition> createLine(Character frequency, Integer position) {
        return IntStream.range(0, 12)
                .mapToObj(pos -> position != null && pos == position ? new RoofPosition(frequency) : new RoofPosition('.'))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
