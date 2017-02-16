package Model;

import java.util.List;
import Controller.Direction;

public class PacMan extends Personnage {

    Position posPacman, posInit;

    private boolean superPacMan = false;
    private int nbrFant = 4, bonus = 0, nbrVies = 2, nbrGomme = 0;

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

    public void setPosition(Position pos) {
        this.posPacman = pos;
    }

    public void manger(int a) {
        bonus += a;
    }

    public void augmenterGomme(int valeur) {
        nbrGomme += valeur;
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

    public int fantomeExist(Position pos, List<Fantome> listFant) {
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
                listFant.remove(fantomeExist(pos, listFant));
                posPacman = pos;
            } else {
                initCase();
                --nbrVies;
            }
    }

    public void deplacer(Position pos, List<Fantome> listFant, Case[][] board) {
        Case caseVide = new CaseVide();
        if (board[pos.getX()][pos.getY()].estAccessible()) {
            if (fantomeExist(pos, listFant) < listFant.size()) {
                deplacerVersFant(pos, listFant);
                if (posPacman.equals(pos)) {
                    board[pos.getX()][pos.getY()].estMangerPar(this);
                    board[posPacman.getX()][posPacman.getY()] = caseVide;
                }
            } else {
                board[pos.getX()][pos.getY()].estMangerPar(this);
                board[posPacman.getX()][posPacman.getY()] = caseVide;
                posPacman = pos;
            }
        }
    }

    public boolean estSuperPacman() {
        return superPacMan;
    }

    public void mangerFant() {
        bonus += 20;
        --nbrFant;

    }

    public void initCase() {
        posPacman = posInit;
    }

    public void setDirectionPacman(Direction d) {
        direction = d;
    }

    public int nbrFantManger() {
        return nbrFant;
    }

    public int nbrViesRestante() {
        return nbrVies;
    }

    public int score() {
        return this.bonus;
    }
}
