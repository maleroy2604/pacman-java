package Model;

public class PacMan extends Personnage {
    
    @Override
    public String toString() {
        return " P ";
    }

    @Override
    public boolean isFantome() {
       return false;
    }
    @Override
    public boolean isPacMan(){
        return true;
        
    }
}
