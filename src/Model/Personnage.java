package Model;

public abstract class Personnage {
    protected int nbrFant=4, bonus=0, nbrVies=2;
    private int nbrGommeMange=0;
    public abstract  boolean mange(Case c);
   public abstract boolean deplacer(Case c);
   
   
   public int getNbrFant(){
       return nbrFant;
   }
   public int getBonus(){
       return bonus;
   }
   public int getNbrVies(){
       return nbrVies;
   }
  

}
