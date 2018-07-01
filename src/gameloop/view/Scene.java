package gameloop.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import gameloop.model.Game;


/**
 *
 */
public class Scene {
    private final JFrame frame;
    private final ScenePanel panel;

    /**
     * @param game the game reference
     * @param w the window width
     * @param h the window height
     */
    public Scene(final Game game, final int w, final int h) {
        this.frame = new JFrame("Qbert Test");
        this.frame.setSize(w, h);
        this.frame.setMinimumSize(new Dimension(w, h));
        this.frame.setResizable(false);
        this.panel = new ScenePanel(game, w, h);

        this.frame.getContentPane().add(this.panel);
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent ev) {
                System.exit(-1);
            }
            public void windowClosed(final WindowEvent ev) {
                System.exit(-1);
            }
        });
        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Method used to render the scene.
     */
    public void render() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                this.panel.render();
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The panel containing the scene and used to perform the rendering.
     */
    public class ScenePanel extends JPanel {

        private Game game;

        /**
         * @param game game reference
         * @param w panel width
         * @param h panel height
         */
        public ScenePanel(final Game game, final int w, final int h) {
            this.setSize(w, h);
            this.setBackground(Color.black);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow(); 

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(final MouseEvent e) {

                }
            });

            this.game = game;
        }


        /**
         * rendering without time interference.
         */
        public void render() {
            this.repaint();
        }

        @Override
        protected final void paintComponent(final Graphics g) {
            super.paintComponent(g);

            g.setColor(new Color(255, 255, 255));
            g.drawString("Hello World", game.getX(), game.getY());
        }
    }
}
