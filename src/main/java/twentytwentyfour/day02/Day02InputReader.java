package twentytwentyfour.day02;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02InputReader implements LineHandler {
    private final List<List<Integer>> levels = new ArrayList<>();

    public Day02InputReader() {
        InputReader.read("day02-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        levels.add(
                Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList()
        );
    }

    public List<List<Integer>> getLevels() {
        return levels;
    }
}
