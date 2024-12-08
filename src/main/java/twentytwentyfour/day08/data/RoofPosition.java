package twentytwentyfour.day08.data;

public class RoofPosition {
    private char frequency;
    private boolean antiNode = false;

    public RoofPosition(char frequency) {
        this.frequency = frequency;
    }

    public char getFrequency() {
        return frequency;
    }

    public boolean isAntenna() {
        return frequency != '.' && frequency != '#';
    }

    public boolean isAntinode() {
        return antiNode;
    }

    public void markAsAntinode() {
        antiNode = true;
        if (frequency == '.') {
            frequency = '#';
        }
    }

    @Override
    public String toString() {
        return String.valueOf(frequency);
    }
}
