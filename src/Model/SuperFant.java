package Model;


import java.util.List;

public class SuperFant extends CompFant {

    private CompFant compF1, compF2;

    public SuperFant(CompFant f1, CompFant f2) {
        super(f1.getPosFant());
        compF1 = f1;
        compF2 = f2;

    }
     public SuperFant(SuperFant f) {
        this(f.compF1,f.compF2);

    }

    @Override
    public int nbrViesReset() {
        return compF1.nbrViesReset() + compF2.nbrViesReset();
    }

    @Override
    public void decomposer(List<CompFant> listCompFant, Case[][] board) {
        CompFant f1 = compF1;
        CompFant f2 = compF2;
        f1.setPosition(this.getPosFant());
        f2.setPosition(this.getPosFant());
        f1.setDirection(Direction.randomDirection());
        f2.setDirection(autreDirection(board, f1.getDirection()));
        listCompFant.add(f1);
        listCompFant.add(f2);
        listCompFant.remove(this);

    }

    @Override
    public String toString() {
        return "SF";
    }

    @Override
    public CompFant copy() {
       return new SuperFant(this);
    }


}
