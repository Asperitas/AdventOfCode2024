package twentytwentyfour;

import twentytwentyfour.day01.Day01Puzzle1;
import twentytwentyfour.day01.Day01Puzzle2;
import twentytwentyfour.day02.Day02Puzzle1;
import twentytwentyfour.day02.Day02Puzzle2;
import twentytwentyfour.day03.Day03Puzzle1;
import twentytwentyfour.day03.Day03Puzzle2;
import twentytwentyfour.day04.Day04InputReader;
import twentytwentyfour.day04.Day04Puzzle1;
import twentytwentyfour.day04.Day04Puzzle2;
import twentytwentyfour.day05.Day05InputReader;
import twentytwentyfour.day05.Day05Puzzle1;
import twentytwentyfour.day05.Day05Puzzle2;
import twentytwentyfour.day06.Day06InputReader;
import twentytwentyfour.day06.Day06Puzzle1;
import twentytwentyfour.day06.Day06Puzzle2;
import twentytwentyfour.day07.Day07InputReader;
import twentytwentyfour.day07.Day07Puzzle1;
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
                new Day03Puzzle2(),
                new Day04Puzzle1(new Day04InputReader().getLines()),
                new Day04Puzzle2(new Day04InputReader().getLines()),
                new Day05Puzzle1(new Day05InputReader()),
                new Day05Puzzle2(new Day05InputReader()),
                new Day06Puzzle1(new Day06InputReader()),
                new Day06Puzzle2(new Day06InputReader()),
                new Day07Puzzle1(new Day07InputReader().getEquations())
        );

        try {
            solutions.forEach(solution -> System.out.printf("%s - solution: %s%n", solution.getClass(), solution.run()));
        } catch (InputReader.FileReadError e) {
            System.err.println(e.getMessage());
        }
    }
}
