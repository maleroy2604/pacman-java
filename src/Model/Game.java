package Model;


import java.util.Observable;







public class Game extends Observable{
   
    private Labyrinthe lab;
    Personnage perso;

    public Game() {
        this.lab = new Labyrinthe();
        perso = lab.getInitialeCase().getPerso();

    }

    public void deplacer(Position p) {
        if (perso.deplacer(lab.getCase(p), p)) {
            lab.initialise(p);
        } else if (lab.getCase(p).estUnPerso()) {
            if (lab.getCase(p).getPerso().isFantome() && perso.getSuperPacman() == false) {
                retourCaseInitial();
            }
        }

    }

    public void retourCaseInitial() {
        lab.setCase(lab.getCase(lab.getPosCourante()), lab.getInitialPosition());
        lab.setCase(new Case(), lab.getPosCourante());
        lab.setPosCourante(lab.getInitialPosition());

    }

    public Labyrinthe getLab() {
        return lab;
    }

    public String ScoreViesRestante() {
        return "Score : " + perso.getBonus() + " " + "Nombre de vies restantes : " + perso.getNbrVies();
    }

    public boolean finDePartie() {
        return perso.getNbFant() == 4 || perso.getNbrVies() < 0;
    }
    public void setChangeAndNotify(Object obj){
        setChanged();
        notifyObservers(obj);
    }
    
}
