
package Model;


public class Case {
    private int x;
    private int y;
    private Element elem;
    private Personnage perso;
    
    public  Case(Element elem,int x ,int y){
        this.elem=elem;
        this.x=x;
        this.y=y;
    }
    public Case(Personnage perso){
        
        this.perso=perso;
        
       
    }
    
    public  Case(){
        
    }
    public void resetCase(){
        elem=null;
    }
    Element getElem(){
        return this.elem;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    Personnage getPerso(){
        return this.perso;
    }
    @Override
   public  String toString(){
        return " ";
    }
}
