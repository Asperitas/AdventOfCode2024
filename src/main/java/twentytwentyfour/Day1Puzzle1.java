package twentytwentyfour;

import twentytwentyfour.util.Day1InputReader;

import java.util.List;

public class Day1Puzzle1 {
    public static int calculateTotalDistance(List<Integer> list1, List<Integer> list2) {
        List<Integer> list1Sorted = list1.stream().sorted().toList();
        List<Integer> list2Sorted = list2.stream().sorted().toList();
        int totalDistance = 0;

        for (int i = 0; i < list1Sorted.size(); i++) {
            totalDistance += Math.max(list1Sorted.get(i), list2Sorted.get(i)) - Math.min(list1Sorted.get(i), list2Sorted.get(i));
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Day1InputReader day1InputReader = new Day1InputReader();

        System.out.println(calculateTotalDistance(day1InputReader.getLeftLocationIds(), day1InputReader.getRightLocationIds()));
    }

}
