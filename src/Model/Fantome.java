
package Model;


public class Fantome extends Personnage {
    public boolean isFantome(){
        return true;
    }
   
    
    @Override
    public String toString(){
        return " F ";
    }

    @Override
    public boolean isPacMan() {
        return false;
    }
  
    
    
}
