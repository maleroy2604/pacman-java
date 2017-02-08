package Vue;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VuePacMan {
     private static final Image pacMan = new Image("file:images/pacman_normal.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j){
         gc.drawImage(
                        pacMan,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
     }
    
    
}

