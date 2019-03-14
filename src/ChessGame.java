import Chess.Board;
import Chess.Coord;
import Chess.GameMode;
import Chess.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessGame extends JFrame {

    public int ICON_SIZE = 72;
    public int BORDER_SIZE = 32;

    private Board board;
    private JPanel panel;
    private JLabel label;
    private GameMode game;

    public static void main(String[] args) {
        new ChessGame();
    }

    ChessGame() {
        board = new Board();
        game = new GameMode();
        initPanel();
        initFrame();
        initLabel();
    }

    private void initLabel() {
        label = new JLabel("Welcome! Press any white figure to start the game!");
        add(label, BorderLayout.SOUTH);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Simple Chess");
        pack();
        setLocationRelativeTo(null);
    }

    public void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(120, 40, 40, 140));
                g.drawImage((Image)board.getBg(), 0, 0, this);
                for (Coord coord : board.getAllCoords()) {
                    if (board.isBackLighted(coord))
                        g.fillRect(coord.x * ICON_SIZE + BORDER_SIZE, coord.y * ICON_SIZE + BORDER_SIZE,
                                ICON_SIZE, ICON_SIZE);
                    g.drawImage(board.getBox(coord).getIcon().getImage(), coord.x * ICON_SIZE + BORDER_SIZE,
                            coord.y * ICON_SIZE + BORDER_SIZE, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Coord coord = new Coord((e.getX() - BORDER_SIZE) / ICON_SIZE,
                        (e.getY() - BORDER_SIZE) / ICON_SIZE);
                if (!coord.validCoord(0, 0)) {
                    return;
                }
                if (e.getButton() == MouseEvent.BUTTON1 &&
                        (game.getState() == GameState.BLACK || game.getState() == GameState.WHITE)) {
                    board.leftClick(coord, game);
                    label.setText(getMessage());
                    game.checkWinner();
                    panel.repaint();
                }
            }
        });
        panel.setPreferredSize(new Dimension(640, 640));
        add(panel);
    }

    private String getMessage() {
        if (game.getState() == GameState.WHITE)
            return "White's turn!";
        else if (game.getState() == GameState.BLACK)
            return "Black's turn!";
        else if (game.getState() == GameState.BLACK_WIN)
            return "Black win!";
        else if (game.getState() == GameState.WHITE_WIN)
            return "White win!";
        else
            return "Oops, something go wrong!";
    }
}
