package Model;

import java.util.LinkedList;
import java.util.List;

public abstract class CompFant {
     protected Position posFant, posInit;
    protected static final List<Position> POS_COIN = new LinkedList<>();
    
    protected Direction direction, prec;
    public CompFant(Position pos ){
        posFant=pos;
        posInit=pos;
    }
    

    public void choixDeplacement(Case[][] board, PacMan pacman,List <CompFant> listCompFant) {
        this.direction = changeDirection(board);
        Position pos = posDeDirection(direction);
        deplacer(pos, pacman,listCompFant);
    }
    public abstract void addCompFant(CompFant compFant);
    public abstract void deplacerVersPacman(Position pos, PacMan pacman) ;
    public abstract void deplacerVersFant(Position pos,List <CompFant> listCompFant);

    public void deplacer(Position pos, PacMan pacman,List <CompFant> listCompFant) {

        if (pos.equals(pacman.getPosition())) {
            deplacerVersPacman(pos, pacman);
        } else if(listCompFant.contains(pos)) {
            
        }else{
            posFant = pos;
        }
        prec = direction;

    }

    public Direction changeDirection(Case[][] board) {
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

    public void initialise() {
        posFant = posInit;
    }
}
