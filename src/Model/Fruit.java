
package Model;


public class Fruit extends Element {
    
    @Override
    public String toString(){
        return " § ";
    }

    @Override
    public boolean isPacgomme() {
        return false;
    }

    @Override
    public boolean isFruit() {
       return true;
    }

    @Override
    public boolean isChampignon() {
        return false;
    }

    @Override
    public boolean isMur() {
        return false;
    }
   
    
}
