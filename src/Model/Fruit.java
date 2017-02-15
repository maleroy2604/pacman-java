package Model;

public class Fruit extends Aliment {

    @Override
    public String toString() {
        return " § ";
    }

    @Override
    public void estMangerPar(PacMan p) {
       p.setSuperPacman(true);
      
       
    }

    

   

}
