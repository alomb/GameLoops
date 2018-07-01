package gameloop.controller;

import java.awt.Toolkit;
import gameloop.model.Game;
import gameloop.view.Scene;

/**
 * A game loop that updates the game dependently on the time elapsed from a game cycle to another, 
 * using interpolation to normalize the time.
 */
public class VariableStepLoop implements GameLoop {

    private static final long FPS = 60;
    private static final long PERIOD = 1000 / VariableStepLoop.FPS;

    private boolean running;
    private boolean stopped;

    private Scene scene;
    private Game game;

    @Override
    public final void setup() {
        this.game = new Game();
        this.scene = new Scene(game, (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2)),
                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2)));

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
            final double delta = elapsed / ((double) VariableStepLoop.PERIOD);
            System.out.println(delta);
            this.processInput();
            this.gameUpdate(delta);
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
     * @param delta the elapsed time passed from the start of the previous game cycle to the beginning of the current,+
     * divided by the optimal time.
     */
    private void gameUpdate(final double delta) {
        if (!this.stopped) {
            this.game.update(delta);
        }
    }

    /**
     * Method used to render the game.
     */
    private void gameRender() {
        this.scene.render();
    }
}
