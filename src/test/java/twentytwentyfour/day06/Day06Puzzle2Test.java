package twentytwentyfour.day06;

import org.junit.jupiter.api.Test;
import twentytwentyfour.day06.data.Direction;
import twentytwentyfour.day06.data.Guard;
import twentytwentyfour.day06.data.MapPosition;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Puzzle2Test {

    @Test
    void testPuzzle2() {
        Guard guard = new Guard(new Point(4, 6), Direction.UP);
        List<List<MapPosition>> map = createMap();

        assertEquals(6, new Day06Puzzle2(guard, map).solve());
    }

    private static List<List<MapPosition>> createMap() {
        List<List<MapPosition>> map = new ArrayList<>();

        Set<Point> obstacles = Set.of(
                new Point(4, 0),
                new Point(9, 1),
                new Point(2, 3),
                new Point(7, 4),
                new Point(1, 6),
                new Point(8, 7),
                new Point(0, 8),
                new Point(6, 9)
        );

        for (int i = 0; i < 10; i++) {
            List<MapPosition> rows = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                MapPosition.Mark mark = MapPosition.Mark.EMPTY;

                if (obstacles.contains(new Point(j, i))) {
                    mark = MapPosition.Mark.OBSTACLE;
                }

                rows.add(new MapPosition(mark));
            }
            map.add(rows);
        }
        return map;
    }
}
