package Model;

public class Champignon extends Aliment {
    

    @Override
    public String toString() {
        return " C ";
    }

    @Override
    public void estMangerPar(PacMan p) {
        p.augmenterVies(1);
        p.setMangeChampi(true);
        p.tempRestantSuperPacman();
    }

    @Override
    public Case copy() {
        return new Champignon();
    }

    
    

   
}
