package Chess;

public class Rook extends Figure{

    Rook(Colors color) {
        super(color);
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean[][] isBackLighted) {
        for (Coord crd : WayBuilder.findWay(coord, 1, 0, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, -1, 0, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, 0, 1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
        for (Coord crd : WayBuilder.findWay(coord, 0, -1, board)) {
            isBackLighted[crd.x][crd.y] = true;
        }
    }
}
