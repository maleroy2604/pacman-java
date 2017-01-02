package Model;

public abstract class Personnage {

    private int nbFant = 0;
    private boolean superPacMan = false;
    private static int bonus;
    private int nbrVies = 2;

    public abstract boolean isFantome();

    public abstract boolean isPacMan();

    public boolean deplacer(Case c, Position p) {
        if (c.isEmpty()) {
            c.setPerso(new PacMan(), p);
            return true;
        } else if (c.estUnPerso()) {
            if (c.getPerso().isFantome()) {
                return pacManVsFantome(c, p);
            }
        
        } else if (c.estUnElement()) {
           return  pacManVsUnElement(c, p);
        }
        
        return false;
    }
        
   private boolean pacManVsUnElement(Case c,Position p){
       if (c.estUnAliment()) {
                mange(c, p);
                c.setPerso(new PacMan(), p);
                return true;
            } else {
                return false;
            }
       
   }    

   private boolean pacManVsFantome(Case c, Position p) {

        if (superPacMan) {
            mangerFantome();
            c.setPerso(new PacMan(), p);
            return true;
        } else {
            nbrVies--;
            return false;
        }
    }

    private void mangerFantome() {
             bonus += 20;
            ++nbFant;
   }
    
    public boolean getSuperPacman(){
        return this.superPacMan;
    }
   private void mange(Case c, Position p) {

        if (c.getElem().isPacgomme()) {
            bonus += 1;
        }
        if (c.getElem().isFruit()) {
            superPacMan = true;
        } else {
            bonus = bonus;
        }
    }

    public int getBonus() {
        return bonus;
    }

    public int getNbrVies() {
        return nbrVies;
    }
    public int getNbFant(){
        
        return nbFant;
    }
   public void setBonus(int b){
       this.bonus=b;
   }
   public void setNbrVies(int a){
       this.nbrVies=a;
   }

  

}
