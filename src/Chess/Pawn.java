package Chess;

import javax.swing.*;

public class Pawn extends Figure{

    private boolean isMoveTwoBoxes;

    Pawn(Colors color) {
        super(color);
        isMoveTwoBoxes = true;
    }

    @Override
    public void move() {

    }

    @Override
    public void backlight() {

    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }
}
