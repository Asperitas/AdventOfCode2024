package twentytwentyfour.day03;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day03InputReader implements LineHandler {
    private final List<String> memorySegments = new ArrayList<>();

    public Day03InputReader() {
        InputReader.read("day03-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        memorySegments.add(line);
    }

    public List<String> getMemorySegments() {
        return memorySegments;
    }
}
