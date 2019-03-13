package Chess;

public class Coord {

    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Coord)obj).x == x && ((Coord)obj).y == y;
    }

    public boolean validCoord(int deltaX, int deltaY) {
        return (x + deltaX >= 0 && x + deltaX <= 7 &&
                y + deltaY >= 0 && y + deltaY <= 7);
    }
}
