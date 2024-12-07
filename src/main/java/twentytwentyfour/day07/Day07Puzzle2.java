package twentytwentyfour.day07;

import java.util.List;
import java.util.Map;

public class Day07Puzzle2 extends Day07Puzzle1 {
    public Day07Puzzle2(Map<Long, List<List<Long>>> equations) {
        super(equations);
    }

    @Override
    protected boolean hasSolution(long targetValue, List<Long> components) {
        if (super.hasSolution(targetValue, components)) {
            return true;
        }

        List<Long> otherComponents = components.stream()
                .limit(components.size() - 1L)
                .toList();

        String targetValueString = String.valueOf(targetValue);
        String lastComponentString = String.valueOf(components.get(components.size() - 1));

        return !otherComponents.isEmpty()
                && isSubstringOf(targetValueString, lastComponentString)
                && hasSolution(parseNewTargetValue(targetValueString, lastComponentString), otherComponents);
    }

    private static long parseNewTargetValue(String targetValueString, String lastComponentString) {
        return Long.parseLong(targetValueString.substring(0, targetValueString.length() - lastComponentString.length()));
    }

    private static boolean isSubstringOf(String superString, String subString) {
        return superString.length() > subString.length()
                && superString.endsWith(subString);
    }
}
