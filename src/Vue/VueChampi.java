
package Vue;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VueChampi  {
     private static final Image champignon = new Image("file:images/champignon.png");
      private static final int TAILLE = 20;
     
     public static  void paintOn(GraphicsContext gc,int i,int j){
         gc.drawImage(
                        champignon,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
     }
    
    
}
