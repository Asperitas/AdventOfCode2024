package twentytwentyfour.day02;

import twentytwentyfour.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day02Puzzle2 implements Solution {
    @Override
    public String run() {
        return String.valueOf(countSafeReports(new Day02InputReader().getLevels()));
    }

    public static long countSafeReports(List<List<Integer>> input) {
        return input.stream()
                .filter(Day02Puzzle2::isReportSafeAfterFix)
                .count();
    }

    public static boolean isReportSafeAfterFix(List<Integer> report) {
        if (Day02Puzzle1.isReportSafe(report)) {
            return true;
        }

        for (int i = 0; i < report.size(); i++) {
            List<Integer> fixedReport = removeLevelFromReport(report, i);

            if (Day02Puzzle1.isReportSafe(fixedReport)) {
                return true;
            }
        }

        return false;
    }

    private static List<Integer> removeLevelFromReport(List<Integer> report, int index) {
        ArrayList<Integer> fixedReport = new ArrayList<>(report);
        fixedReport.remove(index);

        return fixedReport;
    }
}
