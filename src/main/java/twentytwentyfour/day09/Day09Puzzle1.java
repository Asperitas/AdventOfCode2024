package twentytwentyfour.day09;

import twentytwentyfour.Solution;

import java.util.ArrayList;
import java.util.List;

public class Day09Puzzle1 implements Solution {
    private static final String EMPTY_CHARACTER = ".";

    private final String diskMap;

    public Day09Puzzle1(String diskMap) {
        this.diskMap = diskMap;
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        List<String> blocks = createBlocksFromDiskMap();
        defragmentDisk(blocks);

        return calculateChecksum(blocks);
    }

    private List<String> createBlocksFromDiskMap() {
        List<String> blocks = new ArrayList<>();
        String[] diskItems = diskMap.split("");

        for (int i = 0; i < diskItems.length; i++) {
            String fileContents = EMPTY_CHARACTER;
            if (i % 2 == 0) {
                fileContents = String.valueOf(i / 2);
            }

            int fileSize = Integer.parseInt(diskItems[i]);
            for (int j = 0; j < fileSize; j++) {
                blocks.add(fileContents);
            }
        }

        return blocks;
    }

    private static void defragmentDisk(List<String> blocks) {
        int left = 0;
        int right = blocks.size() - 1;

        while (left < right) {
            if (!blocks.get(left).equals(EMPTY_CHARACTER)) {
                left++;
                continue;
            }

            if(blocks.get(right).equals(EMPTY_CHARACTER)) {
                right--;
                continue;
            }

            blocks.set(left, blocks.get(right));
            blocks.set(right, EMPTY_CHARACTER);
        }
    }

    public static long calculateChecksum(List<String> blocks) {
        long checksum = 0;
        for (int i = 0; i < blocks.size(); i++) {
            if (!blocks.get(i).equals(EMPTY_CHARACTER)) {
                checksum += i * Long.parseLong(blocks.get(i));
            }
        }

        return checksum;
    }
}
