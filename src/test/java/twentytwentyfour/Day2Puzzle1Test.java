package twentytwentyfour;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day2Puzzle1Test {

    @ParameterizedTest
    @MethodSource("safeReportsSource")
    void testIsReportSafeWithSafeRanges(List<Integer> report) {
        assertTrue(Day2Puzzle1.isReportSafe(report));
    }

    @ParameterizedTest
    @MethodSource("unsafeReportsSource")
    void testIsReportSafeWithUnsafeRanges(List<Integer> report) {
        assertFalse(Day2Puzzle1.isReportSafe(report));
    }

    static Stream<Arguments> safeReportsSource() {
        return Stream.of(
                Arguments.of(List.of(7, 6, 4, 2, 1)),
                Arguments.of(List.of(1, 3, 6, 7, 9))
        );
    }

    static Stream<Arguments> unsafeReportsSource() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 7, 8, 9)),
                Arguments.of(List.of(9, 7, 6, 2, 1)),
                Arguments.of(List.of(1, 3, 2, 4, 5)),
                Arguments.of(List.of(8, 6, 4, 4, 1))
        );
    }
}
