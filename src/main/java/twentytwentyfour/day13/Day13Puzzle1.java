package twentytwentyfour.day13;

import twentytwentyfour.Solution;
import twentytwentyfour.day13.data.PuzzleInput;

import java.awt.Point;
import java.util.List;

public class Day13Puzzle1 implements Solution {
    private final List<PuzzleInput> puzzleInputs;

    public Day13Puzzle1(List<PuzzleInput> puzzleInputs) {
        this.puzzleInputs = puzzleInputs;
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        return puzzleInputs.stream()
                .map(Day13Puzzle1::calculateLeastMovesToSolve)
                .reduce(0L, Long::sum);
    }

    private static long calculateLeastMovesToSolve(PuzzleInput puzzleInput) {
        Point buttonA = puzzleInput.buttonA();
        Point buttonB = puzzleInput.buttonB();
        Point prize = puzzleInput.prize();

        double bPresses = (double) (buttonA.x * prize.y - buttonA.y * prize.x)
                / (buttonA.x * buttonB.y - buttonA.y * buttonB.x);
        double aPresses = (prize.x - buttonB.x * bPresses) / buttonA.x * 3;

        if (bPresses % 1 != 0 || aPresses % 1 != 0) {
            return 0;
        }

        return (long) aPresses + (long) bPresses;
    }
}
