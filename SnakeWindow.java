import javax.swing.*;
import java.awt.*;

public class SnakeWindow extends JFrame {

    private SnakePanel spanel;

    public SnakeWindow() {
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        spanel = new SnakePanel();
        add(spanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String [] args) {
        SnakeWindow sw = new SnakeWindow();
    }
}
