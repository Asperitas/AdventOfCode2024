package twentytwentyfour.day13;

import twentytwentyfour.day13.data.Point;
import twentytwentyfour.day13.data.PuzzleInput;

import java.util.List;

public class Day13Puzzle2 extends Day13Puzzle1 {
    public static final long PRIZE_MODIFIER = 10000000000000L;

    public Day13Puzzle2(List<PuzzleInput> puzzleInputs) {
        super(
                puzzleInputs.stream()
                        .map(input -> new PuzzleInput(
                                input.buttonA(),
                                input.buttonB(),
                                new Point(input.prize().x() + PRIZE_MODIFIER, input.prize().y() + PRIZE_MODIFIER)
                        ))
                        .toList()
        );
    }
}
