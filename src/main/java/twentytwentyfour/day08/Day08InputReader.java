package twentytwentyfour.day08;

import twentytwentyfour.day08.data.RoofPosition;
import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day08InputReader implements LineHandler {
    private final List<List<RoofPosition>> roof = new ArrayList<>();

    public Day08InputReader() {
        InputReader.read("day08-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        roof.add(
                Arrays.stream(line.split(""))
                        .map(frequency -> new RoofPosition(frequency.charAt(0)))
                        .toList()
        );
    }

    public List<List<RoofPosition>> getRoof() {
        return roof;
    }
}
