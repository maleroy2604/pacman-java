
package Vue;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VuePacGom  {
     private static final Image pacGom = new Image("file:images/boule-de-gomme.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j){
         gc.drawImage(
                        pacGom,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
     }
    
    
}

