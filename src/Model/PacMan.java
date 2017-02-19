package Model;

import java.util.List;
import Controller.Direction;

public class PacMan {

    private Position posPacman, posInit;
    private Direction direction;
    private boolean superPacMan = false;
    private int nbrFant = 4, bonus = 0, nbrVies = 2, nbrGomme = 0;
    private static final int NBR_GOM_TOT = 226;
    private static final Case CASE_VIDE = new CaseVide();

    @Override
    public String toString() {
        return " P ";
    }

    public PacMan(Position pos) {
        this.posPacman = pos;
        this.posInit = pos;
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

    public void setSuperPacman(boolean val) {
        superPacMan = val;
    }

    public void choixDeplacement(Case[][] board, List<Fantome> listFant) {
        switch (direction) {
            case NORD:
                Position posN = new Position(posPacman.getX() - 1, posPacman.getY());
                deplacer(posN, listFant, board);
                break;
            case SUD:
                Position posS = new Position(posPacman.getX() + 1, posPacman.getY());
                deplacer(posS, listFant, board);
                break;
            case OUEST:
                Position posO = new Position(posPacman.getX(), posPacman.getY() - 1);
                deplacer(posO, listFant, board);
                break;
            case EST:
                Position posE = new Position(posPacman.getX(), posPacman.getY() + 1);
                deplacer(posE, listFant, board);
                break;
        }

    }

    private int fantomeExist(Position pos, List<Fantome> listFant) {
        for (int i = 0; i < listFant.size(); ++i) {
            if (listFant.get(i).getPosFant().equals(pos)) {
                return i;
            }
        }
        return listFant.size();
    }

    private void deplacerVersFant(Position pos, List<Fantome> listFant) {
        if (superPacMan) {
            mangerFant();
            Fantome f = listFant.get(fantomeExist(pos, listFant));
            f.setPosition(f.getPosInit());
            posPacman = pos;
        } else {
            initCase();
            --nbrVies;
        }
    }

    private void deplacer(Position pos, List<Fantome> listFant, Case[][] board) {

        if (board[pos.getX()][pos.getY()].estAccessible()) {
            if (fantomeExist(pos, listFant) < listFant.size()) {
                board[pos.getX()][pos.getY()].estMangerPar(this);
                board[posPacman.getX()][posPacman.getY()] = CASE_VIDE;
                deplacerVersFant(pos, listFant);
            } else {
                board[pos.getX()][pos.getY()].estMangerPar(this);
                board[posPacman.getX()][posPacman.getY()] = CASE_VIDE;
                posPacman = pos;
            }

        }
    }

    public boolean estSuperPacman() {
        return superPacMan;
    }

    private void mangerFant() {
        bonus += 20;
//        --nbrFant;

    }

    private void initCase() {
        posPacman = posInit;
    }

    public void setDirectionPacman(Direction d) {
        direction = d;
    }

    public int nbrFantManger() {
        return nbrFant;
    }

    public void setNbrVies(int i) {
        this.nbrVies -= i;
    }

    public int nbrViesRestante() {
        return nbrVies;
    }

    public int nbrGommeRestant() {
        return NBR_GOM_TOT- nbrGomme;
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
}
