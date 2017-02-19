package Model;

import java.util.LinkedList;
import java.util.List;

public class Fantome {

    private Position posFant, posInit;
    private static final List<Position> POS_COIN = new LinkedList<>();
    private Direction direction, prec;
    

    public Fantome(Position p) {
        posFant = p;
        posInit = p;
        this.direction = Direction.randomDirection();
        POS_COIN.add(new Position(11, 1));
        POS_COIN.add(new Position(11, 21));
    }

    public void choixDeplacement(Case[][] board, PacMan pacman) {
        this.direction = changeDirection(board);
        Position pos=posDeDirection(direction);
        deplacer(pos,pacman);
    }

    private void deplacerVersPacman(Position pos, PacMan pacman) {
        if (pacman.estSuperPacman()) {
            initialise();
        } else {
            posFant = pos;
            pacman.setPosition(pacman.getPosInit());
            pacman.setNbrVies(1);
        }
    }

    private void deplacer(Position pos, PacMan pacman) {
        
        if (pos.equals(pacman.getPosition())) {
            deplacerVersPacman(pos, pacman);
        } else {
            posFant=pos;
        }
        prec = direction;

    }

    private Direction changeDirection(Case[][] board) {
        this.direction = Direction.randomDirection();
        Position p = posDeDirection(direction);
        while (direction == Direction.directionOposee(prec) || !board[p.getX()][p.getY()].estAccessible()) {
            this.direction = Direction.randomDirection();
            p = posDeDirection(direction);
            if (POS_COIN.contains(posFant)) {
                return direction = Direction.directionOposee(prec);
            }
        }
        return direction;
    }

    public Position posDeDirection(Direction d) {
        if (d == Direction.NORD) {
            Position posH = new Position(posFant.getX() - 1, posFant.getY());
            return posH;
        }
        if (d == Direction.SUD) {
            Position posH = new Position(posFant.getX() + 1, posFant.getY());
            return posH;
        }
        if (d == Direction.EST) {
            Position posH = new Position(posFant.getX(), posFant.getY() + 1);
            return posH;
        }
        if (d == Direction.OUEST) {
            Position posH = new Position(posFant.getX(), posFant.getY() - 1);
            return posH;
        }
        return null;

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

    private void initialise() {
        posFant = posInit;
    }

    @Override
    public String toString() {
        return " F ";
    }

}
