package twentytwentyfour.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2InputReader {
    private final List<List<Integer>> levels = new ArrayList<>();

    public Day2InputReader() {
        read();
    }

    private void read() {
        InputStream is = Day1InputReader.class.getClassLoader().getResourceAsStream("day2-input.txt");
        try (InputStreamReader isReader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                levels.add(
                        Arrays.stream(line.split(" "))
                                .map(Integer::parseInt)
                                .toList()
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<Integer>> getLevels() {
        return levels;
    }
}
