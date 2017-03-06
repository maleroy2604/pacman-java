package Model;

import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Fantome extends CompFant {

    public Fantome(Position p) {
        super(p);
        this.direction = Direction.randomDirection();
        POS_COIN.add(new Position(11, 1));
        POS_COIN.add(new Position(11, 21));
    }

    @Override
    public void deplacerVersPacman(Position pos, PacMan pacman) {
        if (pacman.estSuperPacman()) {
            initialise();
        } else {
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(1);
        }
    }

    public String toString() {
        return " F ";
    }

//    @Override
//    public void deplacerVersFant(Position pos, List<CompFant> listCompFant) {
//        CompFant f = fantomeExist(pos, listCompFant);
//        SuperFant sf = new SuperFant(pos, f, this);
//        listCompFant.add(sf);
//        listCompFant.remove(f);
//        listCompFant.remove(this);
//        Timeline timeline = new Timeline(new KeyFrame(
//                Duration.seconds(5),
//                ae -> sf.decomposer(listCompFant)
//        ));
//
//        timeline.play();
//
//    }

    @Override
    public void addCompFant(CompFant compFant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decomposer(List<CompFant> listCompFant) {
       
    }

       

}
