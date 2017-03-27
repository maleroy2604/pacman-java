package Model;

public class Mur extends Case {

   
    @Override
    public boolean estAccessible() {
       return false;
    }
    @Override
    public void estMangerPar(PacMan p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
     @Override
    public String toString() {
        return "XXX";
    }

    @Override
    public Case copy() {
        return new Mur();
    }

    


    

}
