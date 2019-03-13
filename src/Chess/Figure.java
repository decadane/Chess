package Chess;

import javax.swing.*;

public abstract class Figure {

    protected Colors color;
    protected ImageIcon icon;

    public abstract void backlight(Coord coord, Figure[][] board, boolean isBackLighted[][]);
    public abstract void move(Coord from, Coord to, Figure[][] board);

    Figure(Colors color) {

        String name = getClass().getName().toLowerCase().substring(6);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        name = "res/" + color.toString().toLowerCase() + name + ".png";

        this.color = color;
        icon = new ImageIcon(name);
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
