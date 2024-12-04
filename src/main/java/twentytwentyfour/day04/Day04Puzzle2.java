package twentytwentyfour.day04;

import twentytwentyfour.Solution;

import java.util.regex.Pattern;

public class Day04Puzzle2 implements Solution {
    private static final Pattern PATTERN = Pattern.compile("^SAM|MAS$");

    private final String[] wordGrid;

    public Day04Puzzle2(String[] wordGrid) {
        this.wordGrid = wordGrid;
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public int solve() {
        // words to be found: MAS | SAM
        final int characterCount = 3;
        final int centerOfWord = characterCount / 2;
        int count = 0;

        for (int row = centerOfWord; row < wordGrid.length - centerOfWord; row++) {
            for (int col = centerOfWord; col < wordGrid[row].length() - centerOfWord; col++) {
                try {
                    if (isCrossMatch(row, col)) {
                        count++;
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Don't care. Ignore!
                }
            }
        }

        return count;
    }

    private boolean isCrossMatch(final int row, final int column) {
        String leftToRight = String.valueOf(new char[] {
                wordGrid[row - 1].charAt(column - 1),
                wordGrid[row].charAt(column),
                wordGrid[row + 1].charAt(column + 1),
        });
        String rightToLeft = String.valueOf(new char[] {
                wordGrid[row - 1].charAt(column + 1),
                wordGrid[row].charAt(column),
                wordGrid[row + 1].charAt(column - 1),
        });

        return PATTERN.matcher(leftToRight).matches() && PATTERN.matcher(rightToLeft).matches();
    }
}
