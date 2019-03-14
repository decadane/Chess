package Chess;

public class GameMode {

    private GameState state;
    private Colors color;

    public GameMode() {
        this.color = Colors.WHITE;
        state = GameState.WHITE;
    }

    public Colors getColor() {
        return color;
    }

    public GameState getState() {
        return state;
    }

    public void toggleState() {
        if (state == GameState.BLACK) {
            state = GameState.WHITE;
        }
        else if (state == GameState.WHITE) {
            state = GameState.BLACK;
        }
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void checkWinner() {
    }
}
