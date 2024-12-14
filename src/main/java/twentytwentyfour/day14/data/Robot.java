package twentytwentyfour.day14.data;

import twentytwentyfour.day13.data.Point;

public class Robot {
    private final Point velocity;

    private Point position;

    public Robot(Point position, Point velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void move(int xBoundary, int yBoundary) {
        position = new Point(
                (xBoundary + position.x() + velocity.x()) % xBoundary,
                (yBoundary + position.y() + velocity.y()) % yBoundary
        );
    }

    public boolean isInQuadrant(Point center, Quadrant quadrant) {
        if (quadrant == Quadrant.TOP_LEFT) {
            return position.x() < center.x() && position.y() < center.y();
        }

        if (quadrant == Quadrant.TOP_RIGHT) {
            return position.x() > center.x() && position.y() < center.y();
        }

        if (quadrant == Quadrant.BOTTOM_LEFT) {
            return position.x() < center.x() && position.y() > center.y();
        }

        return position.x() > center.x() && position.y() > center.y();
    }
}
