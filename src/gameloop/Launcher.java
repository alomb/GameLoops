package gameloop;

import gameloop.controller.GameLoop;
import gameloop.controller.VariableStepLoop;

/**
 *
 */
public final class Launcher {

    /**
     * 
     */
    private Launcher() {

    }

    /**
     * @param args arguments passed by cl
     */
    public static void main(final String[] args) {
        GameLoop loop = new VariableStepLoop();
        loop.setup();
        loop.mainLoop();
    }
}
