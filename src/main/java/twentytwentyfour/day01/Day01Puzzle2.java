package twentytwentyfour.day01;

import twentytwentyfour.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01Puzzle2 implements Solution {
    @Override
    public String run() {
        Day01InputReader reader = new Day01InputReader();

        return String.valueOf(calculateSimilarity(reader.getLeftLocationIds(), reader.getRightLocationIds()));
    }

    public static int calculateSimilarity(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> numberCount = new HashMap<>();

        list2.forEach(locationId -> numberCount.put(locationId, numberCount.getOrDefault(locationId, 0) + 1));

        return list1.stream()
                .reduce(0, (subTotal, locationId) -> subTotal + locationId * numberCount.getOrDefault(locationId, 0));
    }
}
