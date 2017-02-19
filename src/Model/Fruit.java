package Model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Fruit extends Aliment {
    private static int dure=5;
   
    @Override
    public void estMangerPar(PacMan p) {
       p.setSuperPacman(true);
       Timeline timeline =new Timeline(new KeyFrame(
               Duration.seconds(dure),
               ae->p.setSuperPacman(false)
       ));
      
       timeline.play();
       
    }
     @Override
    public String toString() {
        return " § ";
    }


    

   

}
