
package Model;


public class Pacgomme implements Aliment{
    public Pacgomme(){
        
    }
    @Override
    public String toString(){
        return " . ";
    }
    @Override
    public boolean equals(Object o){
        return o instanceof Pacgomme;
    }
}
