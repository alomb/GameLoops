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
     * @param elapsed the time passed from the start of the previous game cycle
     * to the beginning of the current
     */
    public void update(final float elapsed) {
        this.x += elapsed * this.speed;
        this.y += elapsed * this.speed;
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
