package Model;



public abstract class Personnage {
    protected int nbrFant=4, bonus=0, nbrVies,nbrGomme=0;
    protected boolean superPacMan = false;
     
    
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
   public int getNbrGomme(){
       return nbrGomme;
   }
   public boolean getSuperPacMan(){
       return superPacMan;
   }

}
