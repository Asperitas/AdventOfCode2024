package twentytwentyfour.day11;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.Arrays;
import java.util.List;

public class Day11InputReader implements LineHandler {

    private List<Long> stones;

    public Day11InputReader() {
        InputReader.read("day11-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        stones = Arrays.stream(line.split(" "))
                .map(Long::parseLong)
                .toList();
    }

    public List<Long> getStones() {
        return stones;
    }
}
