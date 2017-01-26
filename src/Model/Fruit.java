package Model;

public class Fruit implements Aliment {

    @Override
    public String toString() {
        return " § ";
    }

    @Override
    public boolean estMangerPar(PacMan p) {
       p.estSuperPacMan(true);
       return true;
       
    }

    

   

}
