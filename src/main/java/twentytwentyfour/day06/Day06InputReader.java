package twentytwentyfour.day06;

import twentytwentyfour.day06.data.Direction;
import twentytwentyfour.day06.data.Guard;
import twentytwentyfour.day06.data.MapPosition;
import twentytwentyfour.util.InputReader;
import twentytwentyfour.util.LineHandler;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Day06InputReader implements LineHandler {
    private final List<List<MapPosition>> map = new ArrayList<>();
    private Guard guard;

    public Day06InputReader() {
        InputReader.read("day06-input.txt", this);
    }

    @Override
    public void handleLine(String line) {
        String[] positions = line.split("");

        if (positions.length > 0) {
            fillRow(positions);
        }
    }

    private void fillRow(String[] positions) {
        List<MapPosition> row = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            MapPosition.Mark mark = MapPosition.Mark.EMPTY;

            if ("#".equals(positions[i])) {
                mark = MapPosition.Mark.OBSTACLE;
            } else if ("^".equals(positions[i])) {
                guard = new Guard(new Point(i, map.size()), Direction.UP);
            }

            row.add(new MapPosition(mark));
        }

        map.add(row);
    }

    public List<List<MapPosition>> getMap() {
        return map;
    }

    public Guard getGuard() {
        return guard;
    }
}
