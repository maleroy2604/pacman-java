package Model;

public class Fantome extends Personnage {

    private static int nbrFant = 0;

    @Override
    public String toString() {
        return " F ";
    }

    @Override
    public boolean deplacer(Case c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mange(Case c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
