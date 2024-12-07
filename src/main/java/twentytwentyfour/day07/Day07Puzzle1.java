package twentytwentyfour.day07;

import twentytwentyfour.Solution;

import java.util.List;
import java.util.Map;

public class Day07Puzzle1 implements Solution {
    // the result (key) may be used more than once.
    private final Map<Long, List<List<Long>>> equations;

    public Day07Puzzle1(Map<Long, List<List<Long>>> equations) {
        this.equations = equations;
    }

    @Override
    public String run() {
        return String.valueOf(this.solve());
    }

    public long solve() {
        return equations.entrySet()
                .stream()
                .map(entry -> sumSolutions(entry.getKey(), entry.getValue()))
                .reduce(0L, Long::sum);
    }

    private long sumSolutions(long targetValue, List<List<Long>> equations) {
        return equations
                .stream()
                .map(components -> hasSolution(targetValue, components))
                .map(hasSolution -> Boolean.TRUE.equals(hasSolution) ? targetValue : 0)
                .reduce(0L, Long::sum);
    }

    protected boolean hasSolution(long targetValue, List<Long> components) {
        long lastComponent = components.get(components.size() - 1);
        List<Long> otherComponents = components.stream()
                .limit(components.size() - 1L)
                .toList();

        if (otherComponents.isEmpty()) {
            return targetValue == lastComponent;
        }

        if (targetValue % lastComponent == 0 && hasSolution(targetValue / lastComponent, otherComponents)) {
            return true;
        }

        return targetValue - lastComponent > 0
                && hasSolution(targetValue - lastComponent, otherComponents);
    }
}
