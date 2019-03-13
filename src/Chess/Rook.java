package Chess;

import java.util.ArrayList;

public class Rook extends Figure{

    Rook(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        ArrayList<Coord> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            res.add(new Coord(coord.x, i));
        }
        for (int i = 0; i < 8; i++) {
            res.add(new Coord(i, coord.y));
        }
    }

    @Override
    public void move(Coord from, Coord to, Figure[][] board) {

    }
}
