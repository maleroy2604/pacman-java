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
            pacman.setNbrVies(nbrViesReset());
        }
    }

    public int nbrViesReset() {
        int res = 0;
        for(CompFant f : composants)
            res += f.nbrViesReset();
        return res;
    }

//
    @Override
    public String toString() {
        return "SF";
    }

    @Override
    public void decomposer(List<CompFant> listCompFant, Case[][] board) {
        int dernier = composants.size() - 1, avDernier = composants.size() - 2;
        CompFant f1 = composants.get(dernier), f2 = composants.get(avDernier);
        f1.setPosition(this.getPosFant());
        f2.setPosition(this.getPosFant());
        f1.setDirection(Direction.randomDirection());
        f2.prec=Direction.directionOposee(f1.getDirection());
        Direction d=autreDirection(board, f1.getDirection());
        f2.setDirection(d);
        
//        f1.direction=f1.prec;
//        
//        f2.direction=this.direction;
//        f2.prec=this.direction;
       
        composants.remove(f1);
        composants.remove(f2);
        listCompFant.add(f1);
        listCompFant.add(f2);
       
        listCompFant.remove(this);
        
        
    }

    @Override
    public int getNbrFantList() {
        return composants.size();
    }
    

}
