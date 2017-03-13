package Model;
import java.util.LinkedList;
import java.util.List;

public abstract class CompFant {

    protected Position posFant, posInit;
    protected static final List<Position> POS_COIN = new LinkedList<>();
    protected Direction direction, prec;
    protected static boolean desso = false;
   

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
        while( !board[pos.getX()][pos.getY()].estAccessible()) {
            this.direction = Direction.randomDirection();
            pos = posDeDirection(direction);
            
        }
        deplacer(pos, pacman, listCompFant);
    }
     public abstract int getNbrFantList();
        
     
    public abstract void decomposer(List<CompFant> listCompFant, Case[][] board);
    public abstract int nbrViesReset();

    public abstract void addCompFant(CompFant compFant);

    public abstract void deplacerVersPacman(Position pos, PacMan pacman,List<CompFant> listCompFant);

    public void deplacerVersFant(Position pos, List<CompFant> listCompFant) {
        CompFant f = fantomeExist(pos, listCompFant);
        SuperFant sf = new SuperFant(pos, f, this);
        listCompFant.remove(f);
        listCompFant.remove(this);
        listCompFant.add(sf);
        
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
    public Direction autreDirection(Case[][] board, Direction d){
        Direction di= Direction.randomDirection();
        Position p=posDeDirection(di);
        while(di==d || !board[p.getX()][p.getY()].estAccessible()){
            di=Direction.randomDirection();
            p=posDeDirection(di);
        }
        return di;
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
