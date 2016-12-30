
package Model;


public class Position {
    private int x;
    private int y ;
    
    Position (int x,int y){
        this.x=x;
        this.y=y;
        
    }
    public int getX(){
        return x;
        
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Position)
        return this.x==((Position) o).getX() && this.y==((Position) o).getY();
        else 
            return false ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }
}
