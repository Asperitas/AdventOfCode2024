package twentytwentyfour.day01;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day01InputReader implements LineHandler {
    private final List<Integer> leftLocationIds = new ArrayList<>();
    private final List<Integer> rightLocationIds = new ArrayList<>();

    public Day01InputReader() {
        InputReader.read("day01-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        String[] locationIds = line.split(" {3}");
        leftLocationIds.add(Integer.parseInt(locationIds[0]));
        rightLocationIds.add(Integer.parseInt(locationIds[1]));
    }

    public List<Integer> getLeftLocationIds() {
        return leftLocationIds;
    }

    public List<Integer> getRightLocationIds() {
        return rightLocationIds;
    }
}
