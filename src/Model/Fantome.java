
package Model;


public class Fantome extends Personnage {
    @Override
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
