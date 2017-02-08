
package Vue;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VueFruit  {
     private static final Image fruit = new Image("file:images/fruit.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j){
         gc.drawImage(
                        fruit,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
     }
    
    
}
