package twentytwentyfour.day08.data;

import java.awt.Point;

public class LineUtils {


    public static int findXDiff(Point a, Point b) {
        return Math.abs(a.x - b.x);
    }

    public static int findYDiff(Point a, Point b) {
        return Math.abs(a.y - b.y);
    }

    public static int findDirection(Point a, Point b) {
        return a.x < b.x ? 1 : -1;
    }

    public static int findXStep(Point a, Point b) {
        int xDiff = findXDiff(a, b);
        int yDiff = findYDiff(a, b);

        if (xDiff % yDiff != 0 || yDiff % xDiff != 0) {
            return xDiff;
        }

        return xDiff > yDiff ? xDiff / yDiff : 1;
    }

    public static int findYStep(Point a, Point b) {
        int xDiff = findXDiff(a, b);
        int yDiff = findYDiff(a, b);

        if (xDiff % yDiff != 0 || yDiff % xDiff != 0) {
            return yDiff;
        }

        return yDiff > xDiff ? yDiff / xDiff : 1;
    }
}
