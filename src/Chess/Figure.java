package Chess;

import javax.swing.*;

public abstract class Figure {

    protected Colors color;
    protected ImageIcon icon;

    public abstract void move();
    public abstract void backlight();
    public abstract ImageIcon getIcon();

    Figure(Colors color) {

        String name = getClass().getName().toLowerCase().substring(6);
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        name = "res/" + color.toString().toLowerCase() + name + ".png";

        this.color = color;
        icon = new ImageIcon(name);
    }
}
