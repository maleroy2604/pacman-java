package Model;

public class Champignon extends Aliment {
    

    @Override
    public String toString() {
        return " C ";
    }

    @Override
    public void estMangerPar(PacMan p) {
        p.augmenterVies(1);
        Game.getInstanceGame().tempRestantSuperPacman();
        p.createMem(Game.getInstanceGame());
    }

    @Override
    public Case copy() {
        return new Champignon();
    }

    
    

   
}
