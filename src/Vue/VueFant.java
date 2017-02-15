
package Vue;


import Model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VueFant  {
     private static final Image fantome = new Image("file:images/enemy_normal.png");
     private static final Image vide = new Image("file:images/vide.png");
     private static final Image fantZomb = new Image("file:images/enemy_zombie.png");
      private static final int TAILLE = 20;
     
     public static void paintOn(GraphicsContext gc,int i,int j,Game game ){
         if(game.getPacman().getSuperPacman()){
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
                        fantome,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
         }
         
     }
    
    
}
