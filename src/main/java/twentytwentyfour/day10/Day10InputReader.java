package twentytwentyfour.day10;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day10InputReader implements LineHandler {
    private final List<List<Integer>> topographicMap = new ArrayList<>();

    public Day10InputReader() {
        InputReader.read("day10-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        topographicMap.add(Arrays.stream(line.split("")).map(Integer::parseInt).toList());
    }

    public List<List<Integer>> getTopographicMap() {
        return topographicMap;
    }
}
