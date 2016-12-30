package Model;

public abstract class Personnage {

   
    PacMan p;
    Fantome f;
    public  boolean superPacMan = false, perdreVie = false;
    private static int bonnus;
    private int nbrVies = 2;
    
    
    public abstract boolean isFantome();
    public abstract boolean isPacMan();

    public void deplacer(Case c ,Position p) {
        
        if(!c.getElem().isMur()){
            c.setPerso(new PacMan(), p);
            mange(c,p);

        }
    }
    

    

    public void mange(Case c,Position p) {
        if (c.getPerso().isFantome()) {
            if (superPacMan) {
                bonnus += 20;
            } else {
                nbrVies--;
                perdreVie = true;
                
            } 
        }
        if (c.getElem().isPacgomme()) {
            bonnus += 1;
        }
        if (c.getElem().isFruit()) {
            superPacMan = true;
        } else {
            bonnus = bonnus;
        } 
    }
   
    
    public int getBonnus(){
        return bonnus;
    }
    public int getNbrVies(){
        return nbrVies;
    }
    
    
       
    }

