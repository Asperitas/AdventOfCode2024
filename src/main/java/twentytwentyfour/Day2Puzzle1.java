package twentytwentyfour;

import twentytwentyfour.util.Day2InputReader;

import java.util.List;
import java.util.Objects;

public class Day2Puzzle1 {

    public static void main(String[] args) {
        System.out.println(countSafeReports(new Day2InputReader().getLevels()));
    }

    public static long countSafeReports(List<List<Integer>> input) {
        return input.stream()
                .filter(Day2Puzzle1::isReportSafe)
                .count();
    }

    public static boolean isReportSafe(List<Integer> report) {
        boolean isAscending = report.get(0) < report.get(1);

        for (int i = 1; i < report.size(); i++) {
            if (!isLevelSafe(report.get(i), report.get(i - 1), isAscending)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isLevelSafe(Integer currentLevel, Integer previousLevel, boolean isAscending) {
        if (Objects.equals(currentLevel, previousLevel)) {
            return false;
        }

        if (isWrongDirection(currentLevel, previousLevel, isAscending)) {
            return false;
        }

        int distance = Math.abs(currentLevel - previousLevel);
        return distance <= 3;
    }

    private static boolean isWrongDirection(Integer currentLevel, Integer previousLevel, boolean isAscending) {
        return isAscending && currentLevel < previousLevel || !isAscending && currentLevel > previousLevel;
    }
}
