package gameloop.controller;

/**
 *
 */
public interface GameLoop {

    /**
     * Setup variables and other options.
     */
    void setup();

    /**
     * The method used to:
     * - process the input
     * - update the game
     * - render the game
     * - wait for the next frame
     * and restart until running is true.
     */
    void mainLoop();

    /**
     * This method is used to pause the game. 
     */
    void stopOrResumeGame();
}
