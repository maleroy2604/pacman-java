package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {

   private Labyrinthe lab;
   private List<Fantome> listFant = new  LinkedList<>();
   private PacMan pacman;
   

    public Game() {
       this.lab = new Labyrinthe();
       pacman=lab.getCase(lab.getInitialPosition()).getPacman();
      for(int i=0; i<lab.tailListPosFant();++i){
           listFant.addAll(lab.getCase(lab.positionFantomeInit(i)).getFantome())  ;
       
      }
     

    }

    public void deplacer(Position p) {
        if (pacman.deplacer(lab.getCase(p))) {
            lab.initialise(p);
        } else {
            if(!lab.getCase(p).contientMur())
                retourCaseInitial();

        }
        setChangeAndNotify(this);

    }
    
     public void deplacerFantome(Position p) {
       
        setChangeAndNotify(this);

    }
    private void retourCaseInitial() {
        lab.getCase(lab.getInitialPosition()).placePacman(pacman);
        lab.getCase(lab.getPosCourante()).retirePacman();
        
        lab.setPosCourante(lab.getInitialPosition());

    }

    public Labyrinthe getLab() {
        return lab;
    }
    public Personnage getPerso(){
        return pacman;
    }
    public String ScoreViesRestante() {
        return "Gomme : "+pacman.getNbrGomme()+" - Fantome"+ pacman.getNbrFant()+" - Vies Pacman : " + pacman.getNbrVies()+" - Score : " +pacman.getBonus() ;
    }

    public boolean finDePartie() {
        return pacman.getNbrFant() == 0 || pacman.getNbrVies() <= 0;
    }

    public void setChangeAndNotify(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

}
