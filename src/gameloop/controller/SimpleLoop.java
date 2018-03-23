package gameloop.controller;

import java.awt.Toolkit;

import gameloop.model.Game;
import gameloop.view.Scene;

/**
 *
 */
public class SimpleLoop implements GameLoop {

    private static final long PERIOD = 20;

    private boolean running;
    private boolean stopped;

    private Game game;
    private Scene scene;

    /**
     * 
     */
    public SimpleLoop() {

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
        while (this.running) {
            this.processInput();
            this.gameUpdate();
            this.gameRender();
            try {
                Thread.sleep(PERIOD);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is used to process input.
     */
    private void processInput() {

    }

    /**
     * This method is used to pause the game. 
     */
    @Override
    public void stopOrResumeGame() {
        this.stopped = !this.stopped;
    }

    /**
     * This method is used to update game logic.
     */
    private void gameUpdate() {
        if (!this.stopped) {
            this.game.update();
        }
    }

    /**
     * This method is used to update game rendering.
     */
    private void gameRender() {
        this.scene.render();
    }
}
