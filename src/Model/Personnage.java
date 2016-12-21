
package Model;


public abstract class  Personnage {
   int x;
   int y;
   Personnage(int posx,int posy){
       this.x=posx;
       this.y=posy;
   }
   public void setX(int x){
       this.x=x;
   }
   public void setY(int y){
       this.y=y;
   }
  
   @Override
   public boolean equals(Object o){
       return o instanceof PacMan || o instanceof Fantome;
   }
}
