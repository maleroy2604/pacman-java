package Vue;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VueVide {
     private static final Image vide = new Image("file:images/vide.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j){
         gc.drawImage(
                        vide,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
     }
    
    
}
