package twentytwentyfour.day10;

import java.awt.Point;
import java.util.List;

public class Day10Puzzle2 extends Day10Puzzle1 {
    public Day10Puzzle2(List<List<Integer>> topographicMap) {
        super(topographicMap);
    }

    @Override
    protected void handleTrailEnd(Point endPosition, List<Point> endsReached) {
        scores++;
    }
}
