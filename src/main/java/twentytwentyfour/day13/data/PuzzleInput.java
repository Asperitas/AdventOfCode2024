package twentytwentyfour.day13.data;

import java.awt.Point;

public record PuzzleInput(Point buttonA, Point buttonB, Point prize) {

    public static class Builder {
        private Point buttonA;
        private Point buttonB;
        private Point prize;

        public PuzzleInput build() {
            return new PuzzleInput(buttonA, buttonB, prize);
        }

        public void setButtonA(Point buttonA) {
            this.buttonA = buttonA;
        }

        public void setButtonB(Point buttonB) {
            this.buttonB = buttonB;
        }

        public void setPrize(Point prize) {
            this.prize = prize;
        }
    }
}
