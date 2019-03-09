package Chess;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    public int BOARD_SIZE = 8;

    private Figure table[][] = new Figure[8][8];
    private boolean isBackLighted[][] = new boolean[8][8];
    private BufferedImage bg;

    public Board() {
        setBg();
        initTable();
    }

    private void initTable() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            table[i][0] = new Pawn(Colors.BLACK);
            table[i][1] = new Pawn(Colors.BLACK);
            table[i][6] = new Pawn(Colors.WHITE);
            table[i][7] = new Pawn(Colors.WHITE);
        }
    }

    public Object getBg() {
        return bg;
    }

    public void setBg() {
        File jpgFile = new File("res/deck.jpeg");

        try {
            FileInputStream fis = new FileInputStream(jpgFile);
            bg = ImageIO.read(fis);
        }
        catch (IOException t) {
            System.out.println("Error: bg image doesn't found!");
        }
    }

    public ArrayList<Coord> getAllCoords() {

        ArrayList<Coord> allCoords = new ArrayList<Coord>();

        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                allCoords.add(new Coord(x, y));
            }
        }
        return allCoords;
    }

    public Figure getBox(Coord coord) {
        return table[coord.x][coord.y];
    }

    public void setBox(Figure fig, Coord coord) {
        table[coord.x][coord.y] = fig;
    }

    public void leftClick(Coord coord) {
        if (isBackLighted(coord))
            isBackLighted[coord.x][coord.y] = false;
        else
            isBackLighted[coord.x][coord.y] = true;
    }

    public boolean isBackLighted(Coord coord) {
        return isBackLighted[coord.x][coord.y];
    }
}
