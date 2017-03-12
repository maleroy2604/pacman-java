package Model;

import java.util.ArrayList;
import java.util.List;

public class SuperFant extends CompFant {

    private List<CompFant> composants = new ArrayList<>();

    public SuperFant(Position pos, CompFant f1, CompFant f2) {
        super(pos);
        addCompFant(f1);
        addCompFant(f2);

    }

    public void setSuperFant(CompFant f1, CompFant f2) {
        addCompFant(f1);
        addCompFant(f2);

    }

    @Override
    public void addCompFant(CompFant compFant) {
        composants.add(compFant);
    }

    @Override
    public void deplacerVersPacman(Position pos, PacMan pacman, List<CompFant> listCompFant) {
        if (pacman.estSuperPacman()) {
            super.initialise();
        } else {
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(nbrViesReset(listCompFant));
        }
    }

    public int nbrViesReset(List<CompFant> listCompFant) {
        if (listCompFant.size() == 2) {
            if (composants.size() == 2) {
                return 2;
            } else if (composants.size() > 2) {
                return 3;
            }
        } else if (listCompFant.size() == 1) {
            return 4;
        }

        else if (listCompFant.size() == 3) {
            return 2;   
        }
        return 1;
    }

    @Override
    public void deplacerVersFant(Position pos, List<CompFant> listCompFant) {
        CompFant f = fantomeExist(pos, listCompFant);
        setSuperFant(this, f);
        listCompFant.remove(f);

    }

    @Override
    public String toString() {
        return "SF";
    }

    @Override
    public void decomposer(List<CompFant> listCompFant, Case[][] board) {
        int dernier = composants.size() - 1, avDernier = composants.size() - 2;
        CompFant f1 = composants.get(dernier), f2 = composants.get(avDernier);
        f1.setPosition(this.getPosFant());
       
        f1.prec=Direction.directionOposee(this.direction);
        f1.direction=f1.prec;
        f2.setPosition(this.getPosFant());
        f2.direction=this.direction;
        f2.prec=this.direction;
       
        composants.remove(f1);
        composants.remove(f2);
        listCompFant.add(f1);
        listCompFant.add(f2);
       
        listCompFant.remove(this);
        --cptFantFusion;
        
    }
    

}
