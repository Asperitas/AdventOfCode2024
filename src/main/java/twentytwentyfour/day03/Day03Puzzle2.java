package twentytwentyfour.day03;

import twentytwentyfour.Solution;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Puzzle2 implements Solution {
    private static final Pattern COMMANDS = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do(n't)?\\(\\))");

    private boolean conditionActive = true;

    public int multiplyFromCorruptedMemory(String corruptedMemory) {
        Matcher matcher = COMMANDS.matcher(corruptedMemory);
        int total = 0;

        while (matcher.find()) {
            if ("don't()".equals(matcher.group(0))) {
                conditionActive = false;
            } else if ("do()".equals(matcher.group(0))) {
                conditionActive = true;
            } else if (conditionActive) {
                int multiplicand = Integer.parseInt(matcher.group(2));
                int multiplicator =  Integer.parseInt(matcher.group(3));

                total += multiplicand * multiplicator;
            }
        }

        return total;
    }

    public int multiplyFromCorruptedMemory(List<String> memorySegments) {
        return memorySegments.stream()
                .map(this::multiplyFromCorruptedMemory)
                .reduce(0, Integer::sum);
    }

    @Override
    public String run() {
        return String.valueOf(multiplyFromCorruptedMemory(new Day03InputReader().getMemorySegments()));
    }
}
