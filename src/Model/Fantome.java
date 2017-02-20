package Model;

import java.util.LinkedList;
import java.util.List;

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
    
    @Override
    public void deplacerVersFant(Position pos, List<CompFant> listCompFant) {
        for (CompFant f : listCompFant) {
            if (pos.equals(f.getPosFant())) {
                SuperFant Sf = new SuperFant(pos);
                Sf.addCompFant(f);
                Sf.addCompFant(this);
            }
        }
    }
    
    @Override
    public void addCompFant(CompFant compFant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
