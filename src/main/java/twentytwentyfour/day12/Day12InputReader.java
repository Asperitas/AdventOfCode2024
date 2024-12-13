package twentytwentyfour.day12;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day12InputReader implements LineHandler {
    private final List<List<Character>> gardenPlots = new ArrayList<>();

    public Day12InputReader() {
        InputReader.read("day12-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        gardenPlots.add(line.chars().mapToObj(c -> (char) c).toList());
    }

    public List<List<Character>> getGardenPlots() {
        return gardenPlots;
    }
}
