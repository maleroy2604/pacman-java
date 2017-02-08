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
            if(!lab.getCase(p).estUnMur())
                retourCaseInitial(pacman);

        }
        setChangeAndNotify(this);

    }
    
     public void deplacerFantome(Position p) {
       
        setChangeAndNotify(this);

    }
    private void retourCaseInitial(Personnage perso) {
        lab.getCase(lab.getInitialPosition()).placePerso();
        lab.getCase(lab.getPosCourante()).retirePerso();
        
        lab.setPosCourante(lab.getInitialPosition());

    }

    public Labyrinthe getLab() {
        return lab;
    }
    public Personnage getPerso(int i){
        return perso.get(i);
    }
    public String ScoreViesRestante() {
        return "Gomme : "+perso.get(0).getNbrGomme()+" - Fantome"+ perso.get(0).getNbrFant()+" - Vies Pacman : " + perso.get(0).getNbrVies()+" - Score : " + perso.get(0).getBonus() ;
    }

    public boolean finDePartie() {
        return perso.get(0).getNbrFant() == 0 || perso.get(0).getNbrVies() <= 0;
    }

    public void setChangeAndNotify(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

}
