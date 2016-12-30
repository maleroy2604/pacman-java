
package Model;


public class Case {
    private Position pos;
    private Element elem;
    private Personnage perso;
    
    public Case(Personnage perso ,Position pos){
        this.perso=perso;
        this.pos=pos;
    }
    
    public  Case(Element elem,Position pos ){
        this.elem=elem;
        this.pos=pos;
       
    }
    public  Case(){
        
    }
   
    public  Element getElem(){
        return this.elem;
    }
    public Position getPosition(){
        return pos;
    }
    public Personnage getPerso(){
        return perso;
    }
    
    public void  setElem(Element elem  ,Position pos){
        this.elem=elem;
        this.pos=pos;
    }
    public void setPerso(Personnage perso,Position pos ){
        this.perso=perso;
        this.pos=pos;
    }
   public void setPostion(Position pos ){
       this.pos=pos;
   }
   public boolean estUnPerso(){
       return perso!=null;
   }
   public boolean estUnElement(){
       return elem!=null;
   }
   
   
    @Override
   public  String toString(){
        return "   ";
    }
   public boolean equals(Object o){
        if(o instanceof Case)
            return this.elem==((Case) o).getElem() || this.perso==((Case) o).getPerso();
        else 
            return  false;
   }
}
