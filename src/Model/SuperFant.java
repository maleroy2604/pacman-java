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

    public String toString(){
        return "SF";
    }

    public void decomposer(List<CompFant> listCompFant) {
       CompFant f1=composants.get(0),f2=composants.get(1);
        System.out.println(listCompFant);
        composants.removeAll(composants);
        listCompFant.add(f1);
        listCompFant.add(f2);
        listCompFant.remove(this);
        f1.direction=Direction.directionOposee(f2.direction);
        
     
        System.out.println(listCompFant);
    }
    
    

}
