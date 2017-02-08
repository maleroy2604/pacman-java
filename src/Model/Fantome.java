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
            c.placeFantome(this);
            return true;
        }
            return false;
    }

    @Override
    public boolean mange(Case c) {
        if(c.contientPacman()){
            if(!c.getPacman().superPacMan){
                --nbrVies;
                return true;
            }
            return false;       
        }
        if(c.contientAliment()){
            return true;
        }
        return false;
    }
    

}
