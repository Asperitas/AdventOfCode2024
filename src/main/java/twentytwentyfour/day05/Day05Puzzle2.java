package twentytwentyfour.day05;

import java.util.List;
import java.util.Map;

public class Day05Puzzle2 extends Day05Puzzle1 {

    public Day05Puzzle2(Map<Integer, List<Integer>> orderingRules, List<List<Integer>> pageNumbers) {
        super(orderingRules, pageNumbers);
    }

    public Day05Puzzle2(Day05InputReader inputReader) {
        super(inputReader);
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    @Override
    public int solve() {
        return pageNumbers.stream()
                .filter(numbers -> !isSortedCorrectly(numbers))
                .map(this::sortPageNumbersUsingRulesRules)
                .map(Day05Puzzle1::getMiddlePageNumber)
                .reduce(0, Integer::sum);
    }

    private List<Integer> sortPageNumbersUsingRulesRules(final List<Integer> numbers) {
        return numbers.stream()
                .sorted(this::comparePageNumbers)
                .toList();
    }

    private int comparePageNumbers(Integer a, Integer b) {
        if (orderingRules.containsKey(a) && orderingRules.get(a).contains(b)) {
            return -1;
        }

        if (orderingRules.containsKey(b) && orderingRules.get(b).contains(a)) {
            return 1;
        }

        return 0;
    }
}
