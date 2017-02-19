package Model;

public class Pacgomme extends Aliment {

    
    @Override
    public void estMangerPar(PacMan p) {
       p.manger(1);
       p.augmenterGomme(1);
       
    }
    @Override
    public String toString() {
        return " . ";

    }


    

}
