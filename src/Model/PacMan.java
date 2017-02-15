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
                Position posH = new Position(posPacman.getX() - 1, posPacman.getY());
                deplacer(posH, listFant, board);
                break;
            case SUD:
                Position posB = new Position(posPacman.getX() + 1, posPacman.getY());
                deplacer(posB, listFant, board);
                break;
            case OUEST:
                Position posD = new Position(posPacman.getX(), posPacman.getY() - 1);
                deplacer(posD, listFant, board);
                break;
            case EST:
                Position posG = new Position(posPacman.getX(), posPacman.getY() + 1);
                deplacer(posG, listFant, board);
                break;
        }

    }

    public void deplacer(Position pos, List<Fantome> listFant, Case[][] board) {
        Case caseVide = new CaseVide();
        if (board[pos.getX()][pos.getY()].estAccessible()) {
            board[pos.getX()][pos.getY()].estMangerPar(this);
            board[posPacman.getX()][posPacman.getY()] = caseVide;
            posPacman = pos;

            for (int i=0;i<listFant.size();++i) {
                if (listFant.get(i).getPosFant().equals(pos)) {
                    if (superPacMan) {
                        mangerFant();
                        listFant.remove(i);
                        posPacman = pos;

                    } else {

                        initCase();
                        --nbrVies;
                    }

                }
            }

        }
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
    public int nbrFantManger(){
        return nbrFant;
    }
    public int nbrViesRestante(){
        return nbrVies;
    }
}
