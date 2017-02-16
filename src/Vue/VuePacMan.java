package Vue;

import Model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VuePacMan {

    private static final Image pacMan = new Image("file:images/pacman_normal.png");
    private static final int TAILLE = 20;
    private static final Image superPacMan = new Image("file:images/pacman_invincible.png");

    public static void paintOn(GraphicsContext gc, int i, int j, Game game) {
        if (game.getPacman().estSuperPacman()) {
            gc.drawImage(
                    superPacMan,
                    j * 20,
                    i * 20,
                    TAILLE,
                    TAILLE
            );
        } else {

            gc.drawImage(
                     pacMan,
                    j * 20,
                    i * 20,
                    TAILLE,
                    TAILLE
            );

        }
    }

}
