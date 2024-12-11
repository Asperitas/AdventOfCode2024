package twentytwentyfour.day11;

import twentytwentyfour.Solution;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Day11Puzzle1 implements Solution {
    private List<Long> stones;

    public Day11Puzzle1(List<Long> stones) {
        this.stones = stones;
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public int solve() {
        blink(25);

        return stones.size();
    }

    private void blink(int howOften) {
        if (howOften == 0) {
            return;
        }

        stones = stones.stream()
                .map(this::changeStone)
                .flatMap(Collection::stream)
                .toList();

        blink(howOften - 1);
    }

    private List<Long> changeStone(long stone) {
        if (stone == 0) {
            return List.of(1L);
        }

        if (hasEvenNumberOfDigits(stone)) {
            return splitStoneInHalf(stone);
        }

        return List.of(stone * 2024);
    }

    private List<Long> splitStoneInHalf(long stone) {
        String stoneDigits = String.valueOf(stone);
        int middle = stoneDigits.length() / 2;
        String leftDigits = stoneDigits.substring(0, middle);
        String rightDigits = stoneDigits.substring(middle);

        return Stream.of(leftDigits, rightDigits)
                .map(Long::parseLong)
                .toList();
    }

    private boolean hasEvenNumberOfDigits(long stone) {
        return String.valueOf(stone).length() % 2 == 0;
    }
}
