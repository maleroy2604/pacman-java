
package Model;


public class Pacgomme extends Element{
    
    
  public boolean isPacgomme(){
      return true;
  }
    @Override
    public String toString(){
        return " . ";
   
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
        return false;
    }
}
