package twentytwentyfour.day04;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day04InputReader implements LineHandler {
    List<String> lines = new ArrayList<>();

    public Day04InputReader() {
        InputReader.read("day04-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        lines.add(line);
    }

    public String[] getLines() {
        return lines.toArray(new String[0]);
    }
}
