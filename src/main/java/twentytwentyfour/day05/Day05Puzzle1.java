package twentytwentyfour.day05;

import twentytwentyfour.Solution;

import java.util.List;
import java.util.Map;

public class Day05Puzzle1 implements Solution {

    protected final Map<Integer, List<Integer>> orderingRules;
    protected final List<List<Integer>> pageNumbers;

    public Day05Puzzle1(Map<Integer, List<Integer>> orderingRules, List<List<Integer>> pageNumbers) {
        this.orderingRules = orderingRules;
        this.pageNumbers = pageNumbers;
    }

    public Day05Puzzle1(Day05InputReader inputReader) {
        this.orderingRules = inputReader.getOrderingRules();
        this.pageNumbers = inputReader.getPageNumbers();
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public int solve() {
        return pageNumbers.stream()
                .filter(this::isSortedCorrectly)
                .map(Day05Puzzle1::getMiddlePageNumber)
                .reduce(0, Integer::sum);
    }

    protected boolean isSortedCorrectly(List<Integer> pageNumbers) {
        for (int i = 0; i < pageNumbers.size(); i++) {
            int currentPageNumber = pageNumbers.get(i);
            if (orderingRules.containsKey(currentPageNumber)) {
                List<Integer> currentRules = orderingRules.get(currentPageNumber);

                for (int j = 0; j < i; j++) {
                    if (currentRules.contains(pageNumbers.get(j))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    protected static int getMiddlePageNumber(List<Integer> pageNumbers) {
        return pageNumbers.get(pageNumbers.size() / 2);
    }
}
