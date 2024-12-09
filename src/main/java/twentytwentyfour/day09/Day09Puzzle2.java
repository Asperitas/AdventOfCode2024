package twentytwentyfour.day09;

import twentytwentyfour.Solution;
import twentytwentyfour.day09.data.File;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Day09Puzzle2 implements Solution {
    private static final String EMPTY_CHARACTER = ".";

    private final String diskMap;

    private Deque<File> files; // Seems to be a stack, but SonarLint recommended this instead of Java.util.Stack.
    private List<String> blocks;

    public Day09Puzzle2(String diskMap) {
        this.diskMap = diskMap;
        createBlocksFromDiskMap();
    }

    @Override
    public String run() {
        return String.valueOf(solve());
    }

    public long solve() {
        while (!files.isEmpty()) {
            File file = files.pop();
            int firstEmptyBlockIndex = findFirstEmptySpace(file);

            if (firstEmptyBlockIndex > -1) {
                replaceBlockContents(firstEmptyBlockIndex, file.size(), String.valueOf(file.id()));
                replaceBlockContents(file.index(), file.size(), EMPTY_CHARACTER);
            }
        }

        return calculateChecksum();
    }
    private void createBlocksFromDiskMap() {
        blocks = new ArrayList<>();
        files = new ArrayDeque<>();
        String[] diskItems = diskMap.split("");

        for (int i = 0; i < diskItems.length; i++) {
            String fileContents = EMPTY_CHARACTER;
            int fileSize = Integer.parseInt(diskItems[i]);

            if (i % 2 == 0) {
                File file = new File(i / 2, blocks.size(), fileSize);
                fileContents = file.getContents();
                files.push(file);
            }

            for (int j = 0; j < fileSize; j++) {
                blocks.add(fileContents);
            }
        }
    }

    private int findFirstEmptySpace(File file) {
        int firstIndex = -1;
        int spaceSize = 0;

        for (int i = 0; i < file.index(); i++) {
            if (!EMPTY_CHARACTER.equals(blocks.get(i))) {
                firstIndex = -1;
                spaceSize = 0;
                continue;
            }

            if (firstIndex == -1) {
                firstIndex = i;
            }

            if (++spaceSize == file.size()) {
                return firstIndex;
            }
        }

        return -1;
    }

    private void replaceBlockContents(int startIndex, int size, String content) {
        for (int index = startIndex; index < startIndex + size; index++) {
            blocks.set(index, content);
        }
    }

    private long calculateChecksum() {
        return Day09Puzzle1.calculateChecksum(blocks);
    }
}
