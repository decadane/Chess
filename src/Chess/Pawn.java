package Chess;

public class Pawn extends Figure{

    private boolean isMoveTwoBoxes;

    Pawn(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean isBackLighted[][]) {
        isBackLighted[coord.x][coord.y] = true;
        if (board[coord.x][coord.y].color == Colors.WHITE) {
            if (coord.validCoord(0, -1) && board[coord.x][coord.y - 1].getClass() == Empty.class) {
                isBackLighted[coord.x][coord.y - 1] = true;
            }
            if (coord.validCoord(0, -2) && board[coord.x][coord.y - 2].getClass() == Empty.class &&
                    !isMoveTwoBoxes) {
                isBackLighted[coord.x][coord.y - 2] = true;
            }
            if (coord.validCoord(-1, -1) && board[coord.x - 1][coord.y - 1].color == Colors.BLACK) {
                isBackLighted[coord.x - 1][coord.y - 1] = true;
            }
            if (coord.validCoord(1, -1) && board[coord.x + 1][coord.y - 1].color == Colors.BLACK) {
                isBackLighted[coord.x + 1][coord.y - 1] = true;
            }
        }
        else {
            if (coord.validCoord(0, 1) && board[coord.x][coord.y + 1].getClass() == Empty.class) {
                isBackLighted[coord.x][coord.y + 1] = true;
            }
            if (coord.validCoord(0, 2) && board[coord.x][coord.y + 2].getClass() == Empty.class &&
                    !isMoveTwoBoxes) {
                isBackLighted[coord.x][coord.y + 2] = true;
            }
            if (coord.validCoord(-1, 1) && board[coord.x - 1][coord.y + 1].color == Colors.WHITE) {
                isBackLighted[coord.x - 1][coord.y + 1] = true;
            }
            if (coord.validCoord(1, 1) && board[coord.x + 1][coord.y + 1].color == Colors.WHITE) {
                isBackLighted[coord.x + 1][coord.y + 1] = true;
            }
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
        if (from.y - to.y == 2 || from.y - to.y == -2)
            isMoveTwoBoxes = true;
    }
}
