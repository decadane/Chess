package Chess;

public class Empty extends Figure{

    Empty(Colors color) {
        super(color);
        this.color = color;
    }

    @Override
    public void backlight(Coord coord, Figure[][] board, boolean isBackLighted[][]) {
        isBackLighted[coord.x][coord.y] = true;
    }
}
