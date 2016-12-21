
package Model;


public class Fruit implements Aliment {
    public Fruit(){
        
    }
    @Override
    public String toString(){
        return " § ";
    }
    @Override
    public boolean equals(Object o){
        return o instanceof Fruit;
    }
    
}
