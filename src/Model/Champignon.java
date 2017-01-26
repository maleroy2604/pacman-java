package Model;

public class Champignon implements Aliment {

    @Override
    public String toString() {
        return " C ";
    }

    @Override
    public boolean estMangerPar(PacMan p) {
        p.manger(0);
        return true;
    }

    
    

   
}
