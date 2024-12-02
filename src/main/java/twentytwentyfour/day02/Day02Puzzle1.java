package twentytwentyfour.day02;

import twentytwentyfour.Solution;

import java.util.List;
import java.util.Objects;

public class Day02Puzzle1 implements Solution {
    @Override
    public String run() {
        return String.valueOf(countSafeReports(new Day02InputReader().getLevels()));
    }

    public static long countSafeReports(List<List<Integer>> input) {
        return input.stream()
                .filter(Day02Puzzle1::isReportSafe)
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
