
package Model;


public class Mur extends Element  {
  
   
     @Override
    public String toString(){
        return "XXX";
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
        return false;
    }

    @Override
    public boolean isMur() {
        return true;
    }
    
}
