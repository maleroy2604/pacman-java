package Model;

public class Champignon extends Aliment {

    @Override
    public String toString() {
        return " C ";
    }

    @Override
    public void estMangerPar(PacMan p) {
        p.setNbrVies(-1);
        p.setMangeChampi(true);
        
    }

    @Override
    public Case copy() {
        return new Champignon();
    }

    
    

   
}
