package Model;

public class Pacgomme implements Aliment {

    @Override
    public String toString() {
        return " . ";

    }

    @Override
    public boolean estMangerPar(PacMan p) {
       p.manger(1);
       return true;
    }

    

}
