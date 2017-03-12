package Model;
import java.util.LinkedList;
import java.util.List;

public abstract class CompFant {

    protected Position posFant, posInit;
    protected static final List<Position> POS_COIN = new LinkedList<>();
    protected Direction direction, prec;
    protected static boolean desso = false;
    protected int cptFantFusion=0;

    public CompFant(Position pos) {
        posFant = pos;
        posInit = pos;
        direction = Direction.randomDirection();
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public Direction getDirection() {

        return direction;
    }

    public void choixDeplacement(Case[][] board, PacMan pacman, List<CompFant> listCompFant) {
        Position pos = posDeDirection(direction);
        while(direction==Direction.directionOposee(prec) || !board[pos.getX()][pos.getY()].estAccessible()) {
            this.direction = Direction.randomDirection();
            pos = posDeDirection(direction);
        }
        deplacer(pos, pacman, listCompFant);
    }
     public int getNbrFantList(){
         return cptFantFusion;
     }
    public abstract void decomposer(List<CompFant> listCompFant, Case[][] board);
    public abstract int nbrViesReset(List<CompFant> listCompFant);

    public abstract void addCompFant(CompFant compFant);

    public abstract void deplacerVersPacman(Position pos, PacMan pacman,List<CompFant> listCompFant);

    public void deplacerVersFant(Position pos, List<CompFant> listCompFant) {
        CompFant f = fantomeExist(pos, listCompFant);
        SuperFant sf = new SuperFant(pos, f, this);
        listCompFant.remove(f);
        listCompFant.remove(this);
        listCompFant.add(sf);
        ++cptFantFusion;
    }

    public void deplacer(Position pos, PacMan pacman, List<CompFant> listCompFant) {

        if (pos.equals(pacman.getPosition())) {
            deplacerVersPacman(pos, pacman,listCompFant);
        } else if (fantomeExist(pos, listCompFant) != null) {
            deplacerVersFant(pos, listCompFant);
        } else {
            posFant = pos;
        }
        prec = direction;

    }

    protected CompFant fantomeExist(Position pos, List<CompFant> listFant) {
        for (int i = 0; i < listFant.size(); ++i) {
            if (listFant.get(i).getPosFant().equals(pos)) {
                return listFant.get(i);
            }
        }
        return null;
    }
     

    public Direction changeDirection(Position p, Case[][] board) {

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
