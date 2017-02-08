package Model;



public class Fantome extends Personnage {
    
    public Fantome() {}

   

    @Override
    public String toString() {
        return " F ";
    }

    @Override
    public boolean deplacer(Case c) {
        if(mange(c)){
            c.placePerso(this);
            return true;
        }
            return false;
    }

    @Override
    public boolean mange(Case c) {
        if(c.getPerso()!=this){
            if(!c.getPerso().superPacMan){
                --nbrVies;
                return true;
            }
            return false;       
        }
        if(c.estUnAliment()){
            return true;
        }
        return false;
    }
    

}
