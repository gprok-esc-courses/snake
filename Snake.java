import java.security.DigestException;
import java.util.ArrayList;

public class Snake {

    public enum Direction {RIGHT, LEFT, UP, DOWN}

    private ArrayList<SnakePart> parts;
    private Direction direction;


    public Snake() {
        parts = new ArrayList<>();

        int x = 200;
        int y = 200;

        for(int i = 0; i < 10; i++) {
            SnakePart part = new SnakePart(x, y);
            parts.add(part);
            x -= SnakePart.SIZE;
        }

        direction = Direction.RIGHT;

    }


    public void move(Direction d) {
        SnakePart first = parts.get(0);
        SnakePart last = parts.get(parts.size() - 1);
        SnakePart tmp = last;

        switch(d) {
            case RIGHT:
                if(direction == Direction.LEFT) { return; }
                last.setX(first.getX() + SnakePart.SIZE);
                last.setY(first.getY());
                break;
            case LEFT:
                if(direction == Direction.RIGHT) { return; }
                last.setX(first.getX() - SnakePart.SIZE);
                last.setY(first.getY());
                break;
            case UP:
                if(direction == Direction.DOWN) { return; }
                last.setX(first.getX());
                last.setY(first.getY() - SnakePart.SIZE);
                break;
            case DOWN:
                if(direction == Direction.UP) { return; }
                last.setX(first.getX());
                last.setY(first.getY() + SnakePart.SIZE);
                break;
        }
        parts.remove(last);
        parts.add(0,tmp);
        direction = d;
    }


    public ArrayList<SnakePart> getParts() {
        return parts;
    }


    public int getHeadX() {
        return parts.get(0).getX();
    }


    public int getHeadY() {
        return parts.get(0).getY();
    }
}
