package twentytwentyfour.day09;

import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

public class Day09InputReader implements LineHandler {
    String diskMap = "";

    public Day09InputReader() {
        InputReader.read("day09-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        if (!line.trim().isEmpty()) {
            diskMap = diskMap.concat(line);
        }
    }

    public String getDiskMap() {
        return diskMap;
    }
}
