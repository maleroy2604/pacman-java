
package Vue;

import Model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class VueSuperFant {
     private static final Image fantome2 = new Image("file:images/imgFant2.png");
     private static final Image vide = new Image("file:images/vide.png");
     private static final Image fantZomb = new Image("file:images/enemy_zombie.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j,Game game ){
         if(game.getPacman().estSuperPacman()){
             gc.drawImage(
                       vide,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
             gc.drawImage(
                        fantZomb,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
             
         }else{
             
             gc.drawImage(
                        fantome2,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
         }
         
     }
}
