package gameloop.controller;

import java.awt.Toolkit;

import gameloop.model.Game;
import gameloop.view.Scene;

/**
 *
 */
public class VariableStepLoop implements GameLoop {

    private static final long PERIOD = 20;

    private boolean running;
    private boolean stopped;

    private Scene scene;
    private Game game;

    /**
     * 
     */
    public VariableStepLoop() {

    }

    @Override
    public final void setup() {
        this.game = new Game();
        this.scene = new Scene(game, (int) (2 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3)),
                (int) (2 * (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3)));

        this.running = true;
        this.stopped = false;
        this.gameRender();
    }

    @Override
    public final void mainLoop() {
        long lastTime = System.currentTimeMillis(); 
        while (this.running) {
            final long current = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            this.processInput();
            this.gameUpdate(elapsed);
            this.gameRender();
            this.waitForNextFrame(current);
            lastTime = current;
        }
    }

    /**
     * @param current the time got at the beginning of the current game cycle
     */
    private void waitForNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < VariableStepLoop.PERIOD) {
            try {
                Thread.sleep(VariableStepLoop.PERIOD - dt);
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method used to process input.
     */
    private void processInput() {

    }

    /**
     * Method used to pause the game. 
     */
    public void stopOrResumeGame() {
        this.stopped = !this.stopped;
    }

    /**
     * @param elapsed the time passed from the start of the previous game cycle 
     * to the beginning of the current
     */
    private void gameUpdate(final float elapsed) {
        if (!this.stopped) {
            this.game.update(elapsed);
        }
    }

    /**
     * Method used to render the game.
     */
    private void gameRender() {
        this.scene.render();
    }
}
