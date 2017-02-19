
package Model;


public class Position {
    private int x;
    private int y ;
    
    public Position (int x,int y){
        this.x=x;
        this.y=y;
        
    }
    public int getX(){
        return x;
        
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString(){
        return x+" "+y;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Position){
            Position pos=(Position)o;
            return pos.x==this.x && pos.y==this.y;
        }
        return false;
    }
}
