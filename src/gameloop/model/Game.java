package gameloop.model;

/**
 * An example of a game, to move an object on a 2d space.
 */
public class Game {

    private int x;
    private int y;
    private final float speed = 5f;

    /**
     * 
     */
    public Game() {

    }

    /**
     * The update used by @SimpleLoop.
     */
    public void update() {
        this.x += this.speed;
        this.y += this.speed;
    }

    /**
     * @param delta the elapsed time passed from the start of the previous game cycle to the beginning of the current,+
     * divided by the optimal time.
     */
    public void update(final double delta) {
        this.x += this.speed * delta;
        this.y += this.speed * delta;
    }

    /**
     * @return x coordinate of the object
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return x coordinate of the object
     */
    public int getY() {
        return this.y;
    }

}
