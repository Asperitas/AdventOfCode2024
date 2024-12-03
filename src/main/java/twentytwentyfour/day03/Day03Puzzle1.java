package twentytwentyfour.day03;

import twentytwentyfour.Solution;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Puzzle1 implements Solution {
    private static final Pattern COMMANDS = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

    public static int multiplyFromCorruptedMemory(String corruptedMemory) {
        Matcher matcher = COMMANDS.matcher(corruptedMemory);
        int total = 0;

        while (matcher.find()) {
            int multiplicand = Integer.parseInt(matcher.group(1));
            int multiplicator =  Integer.parseInt(matcher.group(2));

            total += multiplicand * multiplicator;
        }

        return total;
    }

    public static int multiplyFromCorruptedMemory(List<String> memorySegments) {
        return memorySegments.stream()
                .map(Day03Puzzle1::multiplyFromCorruptedMemory)
                .reduce(0, Integer::sum);
    }

    @Override
    public String run() {
        return String.valueOf(multiplyFromCorruptedMemory(new Day03InputReader().getMemorySegments()));
    }
}
