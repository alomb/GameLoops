package gameloop.model;

/**
 *
 */
public class Game {

    private int x;
    private int y;
    private final float speed = 0.35f;

    /**
     * 
     */
    public Game() {

    }

    /**
     * 
     */
    public void update() {
        this.x += 20 * this.speed;
        this.y += 20 * this.speed;
    }

    /**
     * @param delta the elapsed time passed from the start of the previous game cycle to the beginning of the current,+
     * divided by the optimal time.
     */
    public void update(final double delta) {
        this.x += delta * this.speed;
        this.y += delta * this.speed;
    }

    /**
     * @return x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return x coordinate
     */
    public int getY() {
        return this.y;
    }

}
