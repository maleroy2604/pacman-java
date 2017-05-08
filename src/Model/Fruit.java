package Model;



public class Fruit extends Aliment {
    private static final int DURE=5;
   
    @Override
    public void estMangerPar(PacMan p) {
       p.setSuperPacman(true);
       Game.getInstanceGame().superPacmanTime(DURE);
       
       
    }
     @Override
    public String toString() {
        return " § ";
    }

    @Override
    public Case copy() {
       return new Fruit();
    }


    

   

}
