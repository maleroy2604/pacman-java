
package Model;


public class Champignon implements Aliment  {
    public Champignon(){
        
    }
    @Override
    public String toString(){
        return " C ";
    }
    @Override
    public boolean equals(Object o ){
        return o instanceof Champignon;
    }
}
