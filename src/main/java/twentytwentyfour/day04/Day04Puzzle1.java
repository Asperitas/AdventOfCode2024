package twentytwentyfour.day04;

import twentytwentyfour.Solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04Puzzle1 implements Solution {
    private static final Pattern PATTERN = Pattern.compile("XMAS|SAMX");

    private final String[] wordGrid;
    private final int length;
    private final int width;

    public Day04Puzzle1(String[] wordGrid) {
        this.wordGrid = wordGrid;
        this.length = wordGrid.length;
        this.width = wordGrid[0].length();
    }

    @Override
    public String run() {
        return String.valueOf(this.countWordOccurrences());
    }

    public int countWordOccurrences() {
        return countHorizonalOccurrences()
                + countVerticalOccurrences()
                + countDiagonalOccurrences();
    }

    private int countHorizonalOccurrences() {
        int count = 0;

        for (String line : wordGrid) {
            count += countWordOccurrencesForLine(line);
        }

        return count;
    }

    private int countVerticalOccurrences() {
        int count = 0;

        for (int column = 0; column < width; column++) {
            count += countWordOccurrencesForLine(buildVerticalLine(column));
        }

        return count;
    }

    private int countDiagonalOccurrences() {
        return countClockWiseDiagonally() + countAntiClockwiseDiagonally();
    }

    private int countClockWiseDiagonally() {
        int count = 0;

        // Top
        for (int firstRow = 0; firstRow < length; firstRow++) {
            String lineContents = buildDiagonalClockwiseLine(0, firstRow);
            count += countWordOccurrencesForLine(lineContents);
        }

        // Bottom
        for (int firstIndex = 1; firstIndex < width; firstIndex++) {
            String lineContents = buildDiagonalClockwiseLine(firstIndex, length - 1);
            count += countWordOccurrencesForLine(lineContents);
        }

        return count;
    }

    private int countAntiClockwiseDiagonally() {
        int count = 0;

        // Build top, skip lines shorter than the length of the word.
        for (int firstIndex = width; firstIndex >= 0; firstIndex--) {
            String lineContents = buildDiagonalAntiClockwiseLine(firstIndex, 0);
            count += countWordOccurrencesForLine(lineContents);
        }

        // Build bottom, skip lines shorter than the length of the word.
        for (int firstRow = 1; firstRow < length; firstRow++) {
            String lineContents = buildDiagonalAntiClockwiseLine(0, firstRow);
            count += countWordOccurrencesForLine(lineContents);
        }

        return count;
    }

    private static int countWordOccurrencesForLine(String xmasString) {
        final Matcher matcher = PATTERN.matcher(xmasString);
        int count = 0;
        int index = 0;

        while(matcher.find(index)) {
            index = matcher.start() + 1;
            count++;
        }

        return count;
    }

    private String buildVerticalLine(int column) {
        StringBuilder lineBuilder = new StringBuilder();

        for (int row = 0; row < length; row++) {
            lineBuilder.append(wordGrid[row].charAt(column));
        }

        return lineBuilder.toString();
    }

    private String buildDiagonalClockwiseLine(int firstColumn, int firstRow) {
        StringBuilder lineBuilder = new StringBuilder();
        int column = firstColumn;
        int row = firstRow;

        while (row >= 0 && column < width) {
            lineBuilder.append(wordGrid[row--].charAt(column++));
        }

        return lineBuilder.toString();
    }

    private String buildDiagonalAntiClockwiseLine(int firstColumn, int firstRow) {
        StringBuilder lineBuilder = new StringBuilder();
        int row = firstRow;
        int column = firstColumn;

        while (column < width && row < length) {
            lineBuilder.append(wordGrid[row++].charAt(column++));
        }

        return lineBuilder.toString();
    }
}
