package twentytwentyfour;

import twentytwentyfour.day01.Day01Puzzle1;
import twentytwentyfour.day01.Day01Puzzle2;
import twentytwentyfour.day02.Day02Puzzle1;
import twentytwentyfour.day02.Day02Puzzle2;
import twentytwentyfour.day03.Day03Puzzle1;
import twentytwentyfour.day03.Day03Puzzle2;
import twentytwentyfour.util.InputReader;

import java.util.List;

public class SolutionRunner {
    public static void main(String[] args) {
        runAll();
    }

    public static void runAll() {
        List<Solution> solutions = List.of(
                new Day01Puzzle1(),
                new Day01Puzzle2(),
                new Day02Puzzle1(),
                new Day02Puzzle2(),
                new Day03Puzzle1(),
                new Day03Puzzle2()
        );

        try {
            solutions.forEach(solution -> System.out.printf("%s - solution: %s%n", solution.getClass(), solution.run()));
        } catch (InputReader.FileReadError e) {
            System.err.println(e.getMessage());
        }
    }
}
