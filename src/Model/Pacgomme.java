package Model;

public class Pacgomme extends Aliment {

    @Override
    public String toString() {
        return " . ";

    }

    @Override
    public void estMangerPar(PacMan p) {
       p.manger(1);
       p.augmenterGomme(1);
       
    }

    

}
