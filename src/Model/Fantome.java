package Model;

import java.util.LinkedList;
import java.util.List;

public class Fantome {

    private Position posFant, posInit, posPrec;
    private static final List<Position> POS_COIN = new LinkedList<>();
    private Direction direction;

    public Fantome(Position p) {
        posFant = p;
        posInit = p;
        this.direction = Direction.randomDirection();
        POS_COIN.add(new Position(11, 1));
        POS_COIN.add(new Position(11, 21));
    }

    private Position posCoin(Position p) {
        for (Position pos : POS_COIN) {
            if (p.equals(pos)) {
                return pos;
            }
        }
        return null;
    }

    private void fantomeBolque() {
        Position p = posCoin(posFant);
        posFant = posPrec;
        posPrec = p;

    }

    public void choixDeplacement(Case[][] board, PacMan pacman) {
        switch (direction) {
            case NORD:
                Position posH = new Position(posFant.getX() - 1, posFant.getY());
                deplacer(posH, pacman, board);
                break;
            case SUD:
                Position posB = new Position(posFant.getX() + 1, posFant.getY());
                deplacer(posB, pacman, board);
                break;
            case OUEST:
                Position posD = new Position(posFant.getX(), posFant.getY() - 1);
                deplacer(posD, pacman, board);
                break;
            case EST:
                Position posG = new Position(posFant.getX(), posFant.getY() + 1);
                deplacer(posG, pacman, board);
                break;
        }

    }

    private void deplacerVersPacman(Position pos, PacMan pacman) {
        if (pacman.estSuperPacman()) {
            initialise();
        } else {
            posPrec = posFant;
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(1);

        }
    }

    private void deplacer(Position pos, PacMan pacman, Case[][] board) {
        if (board[pos.getX()][pos.getY()].estAccessible()) {
            if (!pos.equals(posPrec)) {
                if (pos.equals(pacman.getPosition())) {
                    deplacerVersPacman(pos, pacman);
                } else {
                    deplacerVersPos(pos);
                }

            } else if (POS_COIN.contains(posFant)) {
                fantomeBolque();
            } 
        }
        this.direction = Direction.randomDirection();
    }

    public void setPosition(Position pos) {
        this.posFant = pos;
    }

    public Position getPosFant() {
        return posFant;
    }

    public Position getPosInit() {
        return this.posInit;
    }

    private void deplacerVersPos(Position pos) {
        posPrec = posFant;
        posFant = pos;
    }

    private void initialise() {
        posFant = posInit;
    }

    @Override
    public String toString() {
        return " F ";
    }

}
