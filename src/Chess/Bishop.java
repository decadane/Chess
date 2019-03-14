package Chess;

import java.util.ArrayList;

public class Bishop extends Figure{

    Bishop(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        isBackLighted[coord.x][coord.y] = true;
        for (Coord crd : findWay(coord, 1, 1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : findWay(coord, -1, -1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : findWay(coord, 1, -1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : findWay(coord, -1, 1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
    }

    @Override
    public void move(Coord from, Coord to, Figure[][] board) {
        Figure tmp = board[from.x][from.y];
        if (board[to.x][to.y].color != tmp.color && board[to.x][to.y].getClass() != Empty.class) {
            board[from.x][from.y] = new Empty(Colors.NA);
        }
        else {
            board[from.x][from.y] = board[to.x][to.y];
        }
        board[to.x][to.y] = tmp;
    }

    private ArrayList<Coord> findWay(Coord coord, int deltaX, int deltaY, Figure[][] board) {
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
