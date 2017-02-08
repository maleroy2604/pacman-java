package Model;

import java.util.ArrayList;
import java.util.List;

public class Case {

    private final Position pos;
    private Aliment alim;
    private PacMan pacman;
    private List<Fantome> listFant=new ArrayList<>();
    private Mur mur;

    public Case(PacMan pacman, Position pos) {
        this.pacman = pacman;
        this.pos = pos;
    }
    public Case(Fantome fant,Position pos){
        this.listFant.add(fant);
        this.pos=pos;
    }

    public Case(Aliment alim, Position pos) {
        this.alim = alim;
        this.pos = pos;
    }

    public Case(Mur mur, Position pos) {
        this.mur = mur;
        this.pos = pos;
    }

    public Case(Position pos) {
        this.pos = pos;
    }

    public Aliment getAlim() {
        return this.alim;
    }

    public Mur getMur() {
        return mur;
    }

    public Position getPosition() {
        return pos;
    }
    public void setPacman(PacMan p){
        this.pacman=p;
    }
    public void setFantome(Fantome f){
        this.listFant.add(f);
    }
    public void retirefantome(){
        this.listFant.remove(listFant.size()-1);
    }
    public PacMan getPacman(){
        return this.pacman;
    }
    public List<Fantome> getFantome(){
        return this.listFant;
    }


    
    public void setAlim(Aliment al){
        this.alim=al;
    }

   public boolean contientPacman() {
        return pacman != null;
    }
   public boolean contientFantome() {
        return !(listFant.isEmpty());
    }

    public boolean contientMur() {
        return mur != null;
    }

    public boolean contientAliment() {
        return alim != null;
    }

    public void placePacman(PacMan p) {
        this.setPacman(p);
         

    }
    
    public void placeFantome(Fantome f){
        setFantome(f);
    }
    public void retirePacman() {
        this.setPacman(null);
        this.setAlim(null);
      
    }

    public void effacerCase(PacMan p) {
        this.pacman=p;
        this.alim=null;
    }

    @Override
    public String toString() {
        return "   ";
    }
    public boolean isEmpty(){
        return mur==null && alim==null && pacman==null && listFant.isEmpty() ;
    }

}
