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
import twentytwentyfour.day07.Day07Puzzle2;
import twentytwentyfour.day08.Day08InputReader;
import twentytwentyfour.day08.Day08Puzzle1;
import twentytwentyfour.day08.Day08Puzzle2;
import twentytwentyfour.day09.Day09InputReader;
import twentytwentyfour.day09.Day09Puzzle1;
import twentytwentyfour.day09.Day09Puzzle2;
import twentytwentyfour.day10.Day10InputReader;
import twentytwentyfour.day10.Day10Puzzle1;
import twentytwentyfour.day10.Day10Puzzle2;
import twentytwentyfour.day11.Day11InputReader;
import twentytwentyfour.day11.Day11Puzzle1;
import twentytwentyfour.day11.Day11Puzzle2;
import twentytwentyfour.day12.Day12InputReader;
import twentytwentyfour.day12.Day12Puzzle1;
import twentytwentyfour.day12.Day12Puzzle2;
import twentytwentyfour.day13.Day13InputReader;
import twentytwentyfour.day13.Day13Puzzle1;
import twentytwentyfour.day13.Day13Puzzle2;
import twentytwentyfour.day14.Day14InputReader;
import twentytwentyfour.day14.Day14Puzzle1;
import twentytwentyfour.day14.Day14Puzzle2;
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
                new Day07Puzzle1(new Day07InputReader().getEquations()),
                new Day07Puzzle2(new Day07InputReader().getEquations()),
                new Day08Puzzle1(new Day08InputReader().getRoof()),
                new Day08Puzzle2(new Day08InputReader().getRoof()),
                new Day09Puzzle1(new Day09InputReader().getDiskMap()),
                new Day09Puzzle2(new Day09InputReader().getDiskMap()),
                new Day10Puzzle1(new Day10InputReader().getTopographicMap()),
                new Day10Puzzle2(new Day10InputReader().getTopographicMap()),
                new Day11Puzzle1(new Day11InputReader().getStones()),
                new Day11Puzzle2(new Day11InputReader().getStones()),
                new Day12Puzzle1(new Day12InputReader().getGardenPlots()),
                new Day12Puzzle2(new Day12InputReader().getGardenPlots()),
                new Day13Puzzle1(new Day13InputReader().getPuzzleInputs()),
                new Day13Puzzle2(new Day13InputReader().getPuzzleInputs()),
                new Day14Puzzle1(new Day14InputReader().getRobots(), 101, 103),
                new Day14Puzzle2(new Day14InputReader().getRobots(), 101, 103)
        );

        try {
            solutions.forEach(solution -> {
                TimedResult result = timeOperation(solution);
                System.out.printf("%s - solution: %s - time: %d ms%n", solution.getClass(), result.result(), result.durationInMs());
            });
        } catch (InputReader.FileReadError e) {
            System.err.println(e.getMessage());
        }
    }

    private static TimedResult timeOperation(Solution solution) {
        long startTime = System.currentTimeMillis();

        String result = solution.run();

        long endTime = System.currentTimeMillis();

        return new TimedResult(result, endTime - startTime);
    }

    private record TimedResult(String result, long durationInMs) {
    }
}
