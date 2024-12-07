package twentytwentyfour.day07;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day07InputReader implements LineHandler {
    private final Map<Long, List<List<Long>>> equations = new HashMap<>();

    public Day07InputReader() {
        InputReader.read("day07-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        String[] segments = line.split(": ");
        String[] operators = segments[1].split(" ");

        long targetValue = Long.parseLong(segments[0]);
        equations.putIfAbsent(targetValue, new ArrayList<>());
        equations.get(targetValue).add( Arrays.stream(operators).map(Long::parseLong).toList());
    }

    public Map<Long, List<List<Long>>> getEquations() {
        return equations;
    }
}
