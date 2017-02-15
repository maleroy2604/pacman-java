package Model;

public class Champignon extends Aliment {

    @Override
    public String toString() {
        return " C ";
    }

    @Override
    public void estMangerPar(PacMan p) {
        p.manger(0);
        
    }

    
    

   
}
