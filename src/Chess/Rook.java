package Chess;

public class Rook extends Figure{

    Rook(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        isBackLighted[coord.x][coord.y] = true;
        for (int i = coord.x - 1; i >= 0; i--) {
            if (board[i][coord.y].getClass() != Empty.class) {
                if (board[i][coord.y].color != board[coord.x][coord.y].color)
                    isBackLighted[i][coord.y] = true;
                break;
            }
            isBackLighted[i][coord.y] = true;
        }
        for (int i = coord.x + 1; i < 8; i++) {
            if (board[i][coord.y].getClass() != Empty.class) {
                if (board[i][coord.y].color != board[coord.x][coord.y].color)
                    isBackLighted[i][coord.y] = true;
                break;
            }
            isBackLighted[i][coord.y] = true;
        }
        for (int i = coord.y - 1; i >= 0; i--) {
            if (board[coord.x][i].getClass() != Empty.class) {
                if (board[coord.x][i].color != board[coord.x][coord.y].color)
                    isBackLighted[coord.x][i] = true;
                break;
            }
            isBackLighted[coord.x][i] = true;
        }
        for (int i = coord.y + 1; i < 8; i++) {
            if (board[coord.x][i].getClass() != Empty.class) {
                if (board[coord.x][i].color != board[coord.x][coord.y].color)
                    isBackLighted[coord.x][i] = true;
                break;
            }
            isBackLighted[coord.x][i] = true;
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
