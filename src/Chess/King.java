package Chess;

public class King extends Figure{
    King(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        for (int i = coord.x - 1; i <= coord.x + 1; i++) {
            for (int j = coord.y - 1; j <= coord.y + 1; j++) {
                if (new Coord(i, j).validCoord(0, 0) &&
                        board[coord.x][coord.y].color != board[i][j].color) {
                    isBackLighted[i][j] = true;
                }
            }
        }
    }
}
