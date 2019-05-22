public class Game implements SnakeListener {

    private int lives;
    private int score;

    public Game() {
        lives = 5;
        score = 0;
    }

    public int getLives() {
        return lives;
    }

    public void decreaseLives() {
        this.lives--;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int value) {
        this.score += value;
    }

    @Override
    public void lifeLost() {
        decreaseLives();
        System.out.println("Lives: " + lives);
    }

    @Override
    public void giftEaten() {
        addScore(10);
    }
}
