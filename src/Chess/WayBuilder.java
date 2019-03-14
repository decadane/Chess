package Chess;

import java.util.ArrayList;

public final class WayBuilder {

    private WayBuilder() {
    }

    public static ArrayList<Coord> findWay(Coord coord, int deltaX, int deltaY, Figure[][] board) {
        Figure tmp = board[coord.x][coord.y];
        ArrayList<Coord> res = new ArrayList<>();
        Coord crd = new Coord(coord.x, coord.y);

        while (crd.x >= 0 && crd.x < 8 && crd.y >= 0 && crd.y < 8) {
            if (board[crd.x][crd.y] != tmp && board[crd.x][crd.y].getClass() != Empty.class) {
                if (board[crd.x][crd.y].color != tmp.color) {
                    res.add(new Coord(crd.x, crd.y));
                }
                break;
            }
            res.add(new Coord(crd.x, crd.y));
            crd.x += deltaX;
            crd.y += deltaY;
        }
        return res;
    }
}
