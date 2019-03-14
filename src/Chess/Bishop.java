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
}
