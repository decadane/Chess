package Chess;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Board {

    public int BOARD_SIZE = 8;

    private Figure board[][] = new Figure[BOARD_SIZE][BOARD_SIZE];
    private boolean isBackLighted[][] = new boolean[BOARD_SIZE][BOARD_SIZE];
    private BufferedImage bg;
    private Coord crdTmp;

    public Board() {
        setBg();
        initTable();
    }

    private void initTable() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i][1] = new Empty(Colors.NA);
//            board[i][1] = new Pawn(Colors.BLACK);
            for (int j = 2; j < 6; j++) {
                board[i][j] = new Empty(Colors.NA);
            }
//            board[i][6] = new Pawn(Colors.WHITE);
            board[i][6] = new Empty(Colors.NA);
        }
        board[0][0] = new Rook(Colors.BLACK);
        board[7][0] = new Rook(Colors.BLACK);
        board[1][0] = new Horse(Colors.BLACK);
        board[6][0] = new Horse(Colors.BLACK);
        board[2][0] = new Bishop(Colors.BLACK);
        board[5][0] = new Bishop(Colors.BLACK);
        board[3][0] = new King(Colors.BLACK);
        board[4][0] = new Queen(Colors.BLACK);
        board[0][7] = new Rook(Colors.WHITE);
        board[7][7] = new Rook(Colors.WHITE);
        board[1][7] = new Horse(Colors.WHITE);
        board[6][7] = new Horse(Colors.WHITE);
        board[2][7] = new Bishop(Colors.WHITE);
        board[5][7] = new Bishop(Colors.WHITE);
        board[3][7] = new King(Colors.WHITE);
        board[4][7] = new Queen(Colors.WHITE);
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
        return board[coord.x][coord.y];
    }

    public boolean isBackLighted(Coord coord) {return isBackLighted[coord.x][coord.y];}

    public void leftClick(Coord coord) {
        if (crdTmp == null && getBox(coord).getClass() != Empty.class) {
            crdTmp = coord;
            board[coord.x][coord.y].backlight(coord, board, isBackLighted);
            return;
        }
        else if (crdTmp != null && crdTmp != coord && isBackLighted(coord)) {
            board[crdTmp.x][crdTmp.y].move(crdTmp, coord, board);
            clearBackLight();
        }
        crdTmp = null;
        clearBackLight();
    }

    private void clearBackLight() {
        for (Coord crd : getAllCoords()) {
            isBackLighted[crd.x][crd.y] = false;
        }
    }
}
