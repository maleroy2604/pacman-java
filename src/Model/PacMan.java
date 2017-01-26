package Model;

public class PacMan extends Personnage {

    private boolean superPacMan = false;
    @Override
    public String toString() {
        return " P ";
    }
    public boolean mangeFant(){
         if (superPacMan) {
                bonus+=20;
                --nbrFant;
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
        if (c.estUnPerso()) {
            return mangeFant();
           
        }
        if(c.estUnAliment()){
            c.getAlim().estMangerPar(this);
            return true;
        }
         return false;   

    }

    @Override
    public boolean deplacer(Case c) {
        if (mange(c)) {
            c.placePerso(this);
            return true;
        }

        return false;
    }

    public void estSuperPacMan(boolean val) {
        superPacMan = val;
    }
    public void manger(int a){
        bonus+=a;
    }

 

   

}
