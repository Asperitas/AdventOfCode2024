package twentytwentyfour;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Puzzle1Test {

    @Test
    void testPuzzle1() {
        List<Integer> list1 = List.of(3, 4, 2, 1, 3, 3);
        List<Integer> list2 = List.of(4, 3, 5, 3, 9, 3);

        assertEquals(11, Day1Puzzle1.calculateTotalDistance(list1, list2));
    }
}
