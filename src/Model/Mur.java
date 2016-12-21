
package Model;


public class Mur implements Element {
     public Mur(){
         
     }
   
     @Override
    public String toString(){
        return " X ";
    }
     @Override
    public boolean equals (Object o ){
        return o instanceof Mur;
    }
}
