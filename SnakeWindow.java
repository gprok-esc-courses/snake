import javax.swing.*;
import java.awt.*;

public class SnakeWindow extends JFrame {

    private SnakePanel spanel;
    private Game game;

    public SnakeWindow() {
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        spanel = new SnakePanel();
        add(spanel, BorderLayout.CENTER);

        game = new Game();
        spanel.addSnakeListener(game);

        setVisible(true);
    }

    public static void main(String [] args) {
        SnakeWindow sw = new SnakeWindow();
    }
}
