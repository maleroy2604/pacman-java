package Model;

import java.util.List;
import Controller.Direction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class PacMan {

    private Position posPacman, posInit;
    private Direction direction;
    private boolean superPacMan = false;
    private int nbrFant = 4, bonus = 0, nbrGomme = 0, timeRestant = 0;
    private Timeline timeLine;
    private static int nbrVies = 5;
    private static boolean mangeChampi = false;

    @Override
    public String toString() {
        return " P ";
    }

    public PacMan(Position pos, int nbrGomme, int bonus, boolean superPac, int timeRestant) {
        this(pos);
        this.nbrGomme = nbrGomme;
        this.bonus = bonus;
        this.superPacMan = superPac;
        this.timeRestant = timeRestant;

    }

    public PacMan(Position pos) {
        this.posPacman = pos;
        this.posInit = pos;
    }

    public PacMan(PacMan pac) {
        this(pac.posPacman, pac.bonus, pac.nbrGomme, pac.superPacMan, pac.timeRestant);
    }

    public Position getPosition() {
        return posPacman;
    }

    public Position getPosInit() {
        return posInit;
    }

    public void setPosition(Position pos) {
        this.posPacman = pos;
    }
     public boolean estSuperPacman() {
        return superPacMan;
    }

    private void mangerFant() {
        bonus += 20;
    }

    public void setDirectionPacman(Direction d) {
        direction = d;
    }
    //-- version console ;
    public int nbrFantManger() {
        return nbrFant;
    }
    public void augmenterVies(int i){
        this.nbrVies += i;
    }
    public void deminuerVies(int i){
         this.nbrVies -= i;
    }

    public int nbrViesRestante() {
        return nbrVies;
    }

    public int nbrGommeManger() {
        return nbrGomme;
    }

    public void manger(int a) {
        bonus += a;
    }

    public void augmenterGomme(int valeur) {
        nbrGomme += valeur;
    }

    public int score() {
        return this.bonus;
    }

    public void setMangeChampi(boolean bol) {
        mangeChampi = bol;
    }

    public void setSuperPacman(boolean val) {
        superPacMan = val;
    }

    public void choixDeplacement(Game g) {
        switch (direction) {
            case NORD:
                Position posN = new Position(posPacman.getX() - 1, posPacman.getY());
                deplacer(posN, g);
                break;
            case SUD:
                Position posS = new Position(posPacman.getX() + 1, posPacman.getY());
                deplacer(posS, g);
                break;
            case OUEST:
                Position posO = new Position(posPacman.getX(), posPacman.getY() - 1);
                deplacer(posO, g);
                break;
            case EST:
                Position posE = new Position(posPacman.getX(), posPacman.getY() + 1);
                deplacer(posE, g);
                break;
        }

    }

    private CompFant fantomeExist(Position pos, List<CompFant> listFant) {
        for (int i = 0; i < listFant.size(); ++i) {
            Position posFant = listFant.get(i).getPosFant();
            if (posFant.equals(pos)) {
                return listFant.get(i);
            }
        }
        return null;
    }

    private void deplacerVersFant(Position pos, Game g) {
        CompFant f = (fantomeExist(pos, g.getFantomes()));
        if (superPacMan) {
            mangerFant();
            f.setPosition(f.getPosInit());
            posPacman = pos;
        } else {
            retourArriereAvcNbrViesReset(f, g);
        }
    }

    private void deplacer(Position pos, Game g) {

        if (g.getBoard()[pos.getX()][pos.getY()].estAccessible()) {
            if (fantomeExist(pos, g.getFantomes()) != null) {
                g.getBoard()[pos.getX()][pos.getY()].estMangerPar(this);
                g.getBoard()[posPacman.getX()][posPacman.getY()] = CaseVide.getInstanceCaseVide();
                deplacerVersFant(pos, g);
            } else {
                g.getBoard()[pos.getX()][pos.getY()].estMangerPar(this);
                g.getBoard()[posPacman.getX()][posPacman.getY()] = CaseVide.getInstanceCaseVide();
                posPacman = pos;
            }
            createMem(g);

        }
    }

    public void retourArriereAvcNbrViesReset(CompFant f, Game g) {

        if (nbrVies < f.nbrViesReset()) {
            g.setFinDePartie(true);
        } else {
            for (int i = 0; i < f.nbrViesReset(); ++i) {
                g.setMemento(g.getGardien().retournEnArriere());
            }
            nbrVies -= f.nbrViesReset();
        }
    }

    public void createMem(Game g) {
        if (mangeChampi) {
            mangeChampi = false;
            g.getGardien().ajouteMemento(g.createMemento());
        }
    }

    public void tempRestantSuperPacman() {
        if (superPacMan) {
            timeRestant = (int) (5 - timeLine.getCurrentTime().toSeconds());
        }
    }

    public void superPacmanTime(int time) {
        timeLine = new Timeline(new KeyFrame(
                Duration.seconds(time),
                ae -> setSuperPacman(false)
        ));

        timeLine.play();
    }

    void tempsRestantSuperPacman() {
        if (timeRestant != 0) {
            superPacmanTime(timeRestant);
        }
    }
}
