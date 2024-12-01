package twentytwentyfour.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Day1InputReader {
    private final List<Integer> leftLocationIds = new ArrayList<>();
    private final List<Integer> rightLocationIds = new ArrayList<>();

    public Day1InputReader() {
        read();
    }

    public List<Integer> getLeftLocationIds() {
        return leftLocationIds;
    }

    public List<Integer> getRightLocationIds() {
        return rightLocationIds;
    }

    private void read() {
        InputStream is = Day1InputReader.class.getClassLoader().getResourceAsStream("day1-input.txt");
        try (InputStreamReader isReader = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(isReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" {3}");
                leftLocationIds.add(Integer.parseInt(split[0]));
                rightLocationIds.add(Integer.parseInt(split[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
