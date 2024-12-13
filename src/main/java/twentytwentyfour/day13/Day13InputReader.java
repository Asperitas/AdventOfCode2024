package twentytwentyfour.day13;

import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day13.data.PuzzleInput;
import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.util.ArrayList;
import java.util.List;

public class Day13InputReader implements LineHandler {
    private final PuzzleInput.Builder puzzleInputBuilder = new PuzzleInput.Builder();
    private final List<PuzzleInput> puzzleInputs = new ArrayList<>();

    public Day13InputReader() {
        InputReader.read("day13-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        if (line.isBlank()) {
            return;
        }

        String[] split = line.split(": ");
        Point coordinates = coordinateStringsToPoint(split[1]);

        if ("Button A".equals(split[0])) {
            puzzleInputBuilder.setButtonA(coordinates);
        } else if ("Button B".equals(split[0])) {
            puzzleInputBuilder.setButtonB(coordinates);
        } else if ("Prize".equals(split[0])) {
            puzzleInputBuilder.setPrize(coordinates);
            puzzleInputs.add(puzzleInputBuilder.build());
        }
    }

    public List<PuzzleInput> getPuzzleInputs() {
        return puzzleInputs;
    }

    private Point coordinateStringsToPoint(String coordinateString) {
        String[] xy = coordinateString.split(", ");

        return new Point(
                Long.parseLong(xy[0].substring(2)),
                Long.parseLong(xy[1].substring(2))
        );
    }
}
