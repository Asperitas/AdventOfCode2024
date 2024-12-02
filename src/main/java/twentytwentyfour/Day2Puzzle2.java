package twentytwentyfour;

import twentytwentyfour.util.Day2InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day2Puzzle2 {
    public static void main(String[] args) {
        System.out.println(countSafeReports(new Day2InputReader().getLevels()));
    }

    public static long countSafeReports(List<List<Integer>> input) {
        return input.stream()
                .filter(Day2Puzzle2::isReportSafeAfterFix)
                .count();
    }

    public static boolean isReportSafeAfterFix(List<Integer> report) {
        if (Day2Puzzle1.isReportSafe(report)) {
            return true;
        }

        for (int i = 0; i < report.size(); i++) {
            List<Integer> fixedReport = removeLevelFromReport(report, i);

            if (Day2Puzzle1.isReportSafe(fixedReport)) {
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
