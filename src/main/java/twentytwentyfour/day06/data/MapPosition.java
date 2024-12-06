package twentytwentyfour.day06.data;

public final class MapPosition {
    private Mark mark;

    public MapPosition(Mark mark) {
        this.mark = mark;
    }

    public boolean isObstacle() {
        return mark == Mark.OBSTACLE || mark == Mark.OBSTRUCTED;
    }

    public boolean isVisited() {
        return mark == Mark.VISITED;
    }

    public boolean isEmpty() {
        return mark == Mark.EMPTY;
    }

    public void markAsVisited() {
        if (mark != Mark.OBSTACLE) {
            mark = Mark.VISITED;
        }
    }

    public void markAsObstructed() {
        mark = Mark.OBSTRUCTED;
    }

    @Override
    public String toString() {
        String output = "";
        switch (mark) {
            case OBSTACLE -> output = "#";
            case VISITED -> output = "X";
            case OBSTRUCTED -> output = "O";
            default -> output = ".";
        }

        return output;
    }

    public enum Mark {
        OBSTACLE,
        VISITED,
        EMPTY,
        OBSTRUCTED
    }
}
