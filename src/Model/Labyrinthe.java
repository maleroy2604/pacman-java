package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Labyrinthe {

    private int nbrFantome = 4;
    private Position posInitiale, posCourante;
    private List<Case> fantomeRandom = new LinkedList<>();
    private Case[][] board = new Case[TAB.length][TAB[0].length];
    private static final int[][] TAB = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 5, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 5, 1},
        {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 4, 1},
        {1, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 0, 0, 0, 0, 0, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 6, 4, 1, 0, 0, 0, 0, 0, 1, 4, 6, 4, 4, 4, 4, 4, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 4, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 4, 1},
        {1, 5, 4, 4, 1, 4, 4, 4, 4, 4, 4, 2, 4, 4, 4, 4, 4, 4, 1, 4, 4, 5, 1},
        {1, 1, 1, 4, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 4, 1, 1, 1},
        {1, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 1},
        {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1},
        {1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1},
        {1, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 6, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Labyrinthe() {

        for (int i = 0; i < TAB.length; ++i) {
            for (int j = 0; j < TAB[i].length; ++j) {

                choixElement(TAB[i][j], new Position(i, j));
            }
        }
        for (int k = 0; k < nbrFantome; ++k) {
            randomFantome();
        }
    }

    private void randomFantome() {

        Random generateur = new Random();
        Case caseFant = fantomeRandom.remove(generateur.nextInt(fantomeRandom.size()));
      caseFant.setPerso(new Fantome(), caseFant.getPosition());

    }

    private void choixElement(int caseInt, Position pos) {

        switch (caseInt) {

            case (1):
                board[pos.getX()][pos.getY()] = new Case(new Mur(), pos);
                break;
            case (2):
                board[pos.getX()][pos.getY()] = new Case(new PacMan(), pos);
                posInitiale = pos;
                posCourante = posInitiale;
                break;
            case (4):
                board[pos.getX()][pos.getY()] = new Case(new Pacgomme(), pos);
                fantomeRandom.add(board[pos.getX()][pos.getY()]);
                break;
            case (5):
                board[pos.getX()][pos.getY()] = new Case(new Fruit(), pos);
                fantomeRandom.add(board[pos.getX()][pos.getY()]);
                break;
            case (6):
                board[pos.getX()][pos.getY()] = new Case(new Champignon(), pos);
                fantomeRandom.add(board[pos.getX()][pos.getY()]);
                break;
            default:
                board[pos.getX()][pos.getY()] = new Case();
                break;

        }
    }

    private String paint() {
        String boardaff = "";
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {

                if (board[i][j].estUnPerso()) {
                    boardaff += board[i][j].getPerso().toString();
                } else if (board[i][j].estUnElement()) {
                    boardaff += board[i][j].getElem().toString();
                } else {
                    boardaff += board[i][j].toString();
                }
            }
            boardaff += "\n";
        }
        return boardaff;
    }

    void initialise(Position p) {
        board[posCourante.getX()][posCourante.getY()] = new Case();
        posCourante = p;
    }

    public Position getPosCourante() {
        return posCourante;
    }

    public Case getCase(Position p) {

        return board[p.getX()][p.getY()];

    }

    public void setCase(Case c, Position p) {
        board[p.getX()][p.getY()] = c;

    }

    public void setPosCourante(Position posCour) {
        this.posCourante = posCour;
    }

    public Case getInitialeCase() {
        return board[posInitiale.getX()][posInitiale.getY()];
    }

    public Position getInitialPosition() {
        return posInitiale;
    }

    public void afficher() {
        System.out.println(paint());
    }
    public Case[][] getBoard(){
        return this.board;
    }
}
