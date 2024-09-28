package shapes;

public class Cube {
    private int length;

    public Cube(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getVolume() {
        return length * length * length;
    }
}
