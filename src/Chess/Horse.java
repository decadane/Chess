package Chess;

import java.util.ArrayList;

public class Horse extends Figure{

    Horse(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        ArrayList<Coord> cells = new ArrayList<>();
        cells.add(new Coord(coord.x, coord.y));
        cells.add(new Coord(coord.x + 2, coord.y + 1));
        cells.add(new Coord(coord.x + 1, coord.y + 2));
        cells.add(new Coord(coord.x - 2, coord.y - 1));
        cells.add(new Coord(coord.x - 1, coord.y - 2));
        cells.add(new Coord(coord.x + 2, coord.y - 1));
        cells.add(new Coord(coord.x + 1, coord.y - 2));
        cells.add(new Coord(coord.x - 2, coord.y + 1));
        cells.add(new Coord(coord.x - 1, coord.y + 2));
        for (Coord crd : cells) {
            if ((!crd.validCoord(0, 0)) ||
                    (board[crd.x][crd.y].color == board[coord.x][coord.y].color))
                continue;
            isBackLighted[crd.x][crd.y] = true;
        }
    }
}
