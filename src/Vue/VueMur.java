package Vue;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VueMur {

    private static final Image mur = new Image("file:images/mur.png");
    private static final int TAILLE = 20;

    public static void paintOn(GraphicsContext gc, int i, int j) {
        gc.drawImage(
                mur,
                j * 20,
                i * 20,
                TAILLE,
                TAILLE
        );
    }

}
