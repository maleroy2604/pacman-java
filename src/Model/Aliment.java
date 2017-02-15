
package Model;


public abstract class  Aliment extends Case {
    
   @Override
   public boolean estAccessible(){
       return true;
   } 
   @Override
   public abstract void estMangerPar(PacMan p);
  
}
