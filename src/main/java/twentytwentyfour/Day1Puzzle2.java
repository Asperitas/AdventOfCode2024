package twentytwentyfour;

import twentytwentyfour.util.Day1InputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1Puzzle2 {
    public static int calculateSimilarity(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> numberCount = new HashMap<>();

        list2.forEach(locationId -> numberCount.put(locationId, numberCount.getOrDefault(locationId, 0) + 1));

        return list1.stream()
                .reduce(0, (subTotal, locationId) -> subTotal + locationId * numberCount.getOrDefault(locationId, 0));
    }

    public static void main(String[] args) {
        Day1InputReader day1InputReader = new Day1InputReader();

        System.out.println(calculateSimilarity(day1InputReader.getLeftLocationIds(), day1InputReader.getRightLocationIds()));
    }
}
