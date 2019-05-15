import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class SnakePanel extends JPanel {

    private Snake snake;

    public SnakePanel() {
        setFocusable(true);
        requestFocusInWindow();
        setBackground(Color.BLUE);

        addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) { }

           @Override
           public void keyPressed(KeyEvent e) {
               System.out.println("click");
               if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                   snake.move(Snake.Direction.RIGHT);
               }
               else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                   snake.move(Snake.Direction.LEFT);
               }
               else if(e.getKeyCode() == KeyEvent.VK_UP) {
                   snake.move(Snake.Direction.UP);
               }
               else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                   snake.move(Snake.Direction.DOWN);
               }
               repaint();
           }

           @Override
           public void keyReleased(KeyEvent e) { }
        });

        snake = new Snake();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();

        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLUE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        ArrayList<SnakePart> parts = snake.getParts();

        Iterator<SnakePart> iter = parts.iterator();

        int counter = 0;
        while(iter.hasNext()) {
            SnakePart p = iter.next();
            if(counter == 0) {
                g2.setColor(Color.RED);
            }
            else {
                g2.setColor(Color.YELLOW);
            }
            g2.fillRect(p.getX(), p.getY(), SnakePart.SIZE, SnakePart.SIZE);
            counter++;
        }
    }

}
