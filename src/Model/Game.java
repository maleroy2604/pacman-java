package Model;

import java.util.Observable;

public class Game extends Observable {

    private Labyrinthe lab;
   Personnage perso;

    public Game() {
        this.lab = new Labyrinthe();
        perso = lab.getInitialeCase().getPerso();

    }

    public void deplacer(Position p) {
        if (perso.deplacer(lab.getCase(p))) {
            lab.initialise(p);
        } else {
            if(!lab.getCase(p).estUnMur())
                retourCaseInitial(perso);

        }

    }

    private void retourCaseInitial(Personnage perso) {
        lab.getCase(lab.getInitialPosition()).placePerso(perso);
        lab.getCase(lab.getPosCourante()).retirePerso();
        
        lab.setPosCourante(lab.getInitialPosition());

    }

    public Labyrinthe getLab() {
        return lab;
    }

    public String ScoreViesRestante() {
        return "Score : " + perso.getBonus() + " " + "Nombre de vies restantes : " + perso.getNbrVies() ;
    }

    public boolean finDePartie() {
        return perso.getNbrFant() == 0 || perso.getNbrVies() < 0;
    }

    public void setChangeAndNotify(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

}
