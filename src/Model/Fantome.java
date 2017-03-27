package Model;

import java.util.List;


public class Fantome extends CompFant {

    public Fantome(Position p) {
        super(p);
    }
    public Fantome(Fantome f) {
        this(f.posFant);
    }
    @Override
    public String toString() {
        return " F ";
    }

    @Override
    public void decomposer(List<CompFant> listCompFant,Case[][] board) {
       
    }

    @Override
    public int nbrViesReset() {
        return 1;
    }

    @Override
    public CompFant copy() {
        return new Fantome(this);
    }

    
       

}
