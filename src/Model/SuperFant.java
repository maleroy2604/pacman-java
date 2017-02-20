package Model;

import java.util.ArrayList;
import java.util.List;

public class SuperFant extends CompFant {

    List<CompFant> composants = new ArrayList<>();

    public SuperFant(Position pos) {
        super(pos);

    }

    public void addCompFant(CompFant compFant) {
        composants.add(compFant);
    }

    @Override
    public void deplacerVersPacman(Position pos, PacMan pacman) {
        if (pacman.estSuperPacman()) {
            super.initialise();
        } else {
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(composants.size());
        }
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
    

}
