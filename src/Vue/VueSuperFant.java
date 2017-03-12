
package Vue;


import Model.CompFant;
import Model.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class VueSuperFant {
     private static final Image fantome2 = new Image("file:images/imgFant2.png");
     private static final Image fantome3 = new Image("file:images/imgFant3.png");
     private static final Image fantome4 = new Image("file:images/imgFant4.png");
     private static final Image vide = new Image("file:images/vide.png");
     private static final Image fantZomb = new Image("file:images/enemy_zombie.png");
     private static final int TAILLE = 20;
     private static int nbrSuperFant;
      
      public static void superFantNbr(Game game,CompFant f){
        if (game.getFantomes().size() == 2) {
            if (f.getNbrFantList() == 1) {
                nbrSuperFant=2;
            } else {
                nbrSuperFant= 3;
            }
        } else if (game.getFantomes().size() == 1) {
            nbrSuperFant= 4;
        }

        else if (game.getFantomes().size() == 3) {
            nbrSuperFant= 2;   
        }
        
      }
     
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
             
         }else if(nbrSuperFant==2){
             
             gc.drawImage(
                        fantome2,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
         }else if(nbrSuperFant==3){
             
             gc.drawImage(
                        fantome3,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
         }else if(nbrSuperFant==4){
             
             gc.drawImage(
                        fantome4,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
         }
         
     }
}
