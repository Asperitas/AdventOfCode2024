package twentytwentyfour.day01;

import twentytwentyfour.Solution;

import java.util.List;

public class Day01Puzzle1 implements Solution {
    @Override
    public String run() {
        Day01InputReader reader = new Day01InputReader();

        return String.valueOf(calculateTotalDistance(reader.getLeftLocationIds(), reader.getRightLocationIds()));
    }

    public static int calculateTotalDistance(List<Integer> list1, List<Integer> list2) {
        List<Integer> list1Sorted = list1.stream().sorted().toList();
        List<Integer> list2Sorted = list2.stream().sorted().toList();
        int totalDistance = 0;

        for (int i = 0; i < list1Sorted.size(); i++) {
            totalDistance += Math.max(list1Sorted.get(i), list2Sorted.get(i)) - Math.min(list1Sorted.get(i), list2Sorted.get(i));
        }

        return totalDistance;
    }
}
