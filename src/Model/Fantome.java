package Model;

import java.util.List;


public class Fantome extends CompFant {

    public Fantome(Position p) {
        super(p);
        
        POS_COIN.add(new Position(11, 1));
        POS_COIN.add(new Position(11, 21));
    }

    @Override
    public void deplacerVersPacman(Position pos, PacMan pacman,List<CompFant> listCompFant) {
        if (pacman.estSuperPacman()) {
            initialise();
        } else {
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(nbrViesReset());
        }
    }

    public String toString() {
        return " F ";
    }

   

    @Override
    public void addCompFant(CompFant compFant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decomposer(List<CompFant> listCompFant,Case[][] board) {
       
    }

    @Override
    public int nbrViesReset() {
        return 1;
    }

    @Override
    public int getNbrFantList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
       

}
