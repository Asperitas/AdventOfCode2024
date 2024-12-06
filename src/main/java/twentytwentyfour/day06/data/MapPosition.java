package twentytwentyfour.day06.data;

public final class MapPosition {
    private Mark mark;

    public MapPosition(Mark mark) {
        this.mark = mark;
    }

    public boolean isObstacle() {
        return mark == Mark.OBSTACLE;
    }

    public boolean isVisited() {
        return mark == Mark.VISITED;
    }

    public boolean isEmpty() {
        return mark == Mark.EMPTY;
    }

    public void markAsVisited() {
        if (!isObstacle()) {
            mark = Mark.VISITED;
        }
    }

    @Override
    public String toString() {
        String output = "";
        switch (mark) {
            case OBSTACLE -> output = "#";
            case VISITED -> output = "X";
            default -> output = ".";
        }

        return output;
    }

    public enum Mark {
        OBSTACLE,
        VISITED,
        EMPTY
    }
}
