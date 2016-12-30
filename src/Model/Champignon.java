
package Model;


public class Champignon extends Element  {
    
    
   @Override
   public String toString(){
    return " C ";
   }

    @Override
    public boolean isPacgomme() {
        return false;
    }

    @Override
    public boolean isFruit() {
        return false;
    }

    @Override
    public boolean isChampignon() {
        return true;
    }

    @Override
    public boolean isMur() {
        return false;
    }
}
