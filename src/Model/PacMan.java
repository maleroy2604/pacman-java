package Model;



public class PacMan extends Personnage {
    
    
    
    @Override
    public String toString() {
        return " P ";
    }

    public PacMan() {
        super();
        nbrVies = 2;
    }

    public boolean mangeFant(Case c) {
        if (superPacMan) {
            bonus += 20;
            --nbrFant;
            ++nbrGomme;
            c.retirefantome();
            return true;
        } else {
            --nbrVies;
            return false;
        }
    }

    @Override
    public boolean mange(Case c) {
        if (c.isEmpty()) {
            return true;
        }
        if (c.contientFantome()) {

            return mangeFant(c);
            
        }
        if (c.contientAliment()) {
            c.getAlim().estMangerPar(this);
            return true;
        }
        return false;

    }

    @Override
    public boolean deplacer(Case c) {
        if (mange(c)) {
            
            c.placePacman(this);
            return true;
        }

        return false;
    }

    public void estSuperPacMan(boolean val) {
        superPacMan = val;
    }

    public void manger(int a) {
        bonus += a;
    }
    public void augmenterGomme(int valeur){
        nbrGomme+=valeur;
    }
    
    

}
