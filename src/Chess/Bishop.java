package Chess;

public class Bishop extends Figure{

    Bishop(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        for (Coord crd : WayBuilder.findWay(coord, 1, 1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, -1, -1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, 1, -1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, -1, 1, board)) {
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
}
