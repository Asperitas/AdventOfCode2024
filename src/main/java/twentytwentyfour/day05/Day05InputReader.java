package twentytwentyfour.day05;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day05InputReader implements LineHandler {

    private final Map<Integer, List<Integer>> orderingRules = new HashMap<>();
    private final List<List<Integer>> pageNumbers = new ArrayList<>();

    public Day05InputReader() {
        InputReader.read("day05-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        if (line.contains("|")) {
            createOrderingRules(line);
        } else if (line.contains(",")) {
            createPageNumbers(line);
        }
    }

    public Map<Integer, List<Integer>> getOrderingRules() {
        return orderingRules;
    }

    public List<List<Integer>> getPageNumbers() {
        return pageNumbers;
    }

    private void createOrderingRules(String line) {
        String[] segments = line.split("\\|");
        int key = Integer.parseInt(segments[0]);
        int value = Integer.parseInt(segments[1]);

        orderingRules.putIfAbsent(key, new ArrayList<>());
        orderingRules.get(key).add(value);
    }

    private void createPageNumbers(String line) {
        String[] segments = line.split(",");

        pageNumbers.add(Arrays.stream(segments).map(Integer::parseInt).toList());
    }
}
