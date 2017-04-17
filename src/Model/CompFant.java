package Model;

import java.util.List;

public abstract class CompFant {

    protected Position posFant, posInit;
    protected Direction direction;

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

    public void choixDeplacement(Game g) {
        Position pos = posDeDirection(direction);
        while (!g.getBoard()[pos.getX()][pos.getY()].estAccessible()) {
            this.direction = Direction.randomDirection();
            pos = posDeDirection(direction);
        }
        deplacer(pos, g);
    }

    public void deplacerVersPacman(Position pos, Game g) {
        if (g.getPacman().estSuperPacman()) {
            initialise();
        } else {
            posFant = pos;
            retourArriereAvecNbrViesReset(g);

        }
    }

    public void retourArriereAvecNbrViesReset(Game g) {

        if (g.getPacman().nbrViesRestante() < this.nbrViesReset()) {
            g.setFinDePartie(true);
        } else {
            for (int i = 0; i < nbrViesReset(); ++i) {
                g.setMemento(g.getGardien().retournEnArriere());
            }
            g.getPacman().deminuerVies(nbrViesReset());
        }
    }

    public void deplacerVersFant(Position pos, Game g) {
        CompFant f = fantomeExist(pos, g.getFantomes());
        SuperFant sf = new SuperFant(f, this);
        g.getFantomes().remove(f);
        g.getFantomes().remove(this);
        g.getFantomes().add(sf);

    }

    public void deplacer(Position pos, Game g) {

        if (pos.equals(g.getPacman().getPosition())) {
            deplacerVersPacman(pos, g);
        } else if (fantomeExist(pos, g.getFantomes()) != null) {
            deplacerVersFant(pos, g);
        } else {
            posFant = pos;
        }
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

    public Direction autreDirection(Case[][] board, Direction d) {
        Direction di = Direction.randomDirection();
        Position p = posDeDirection(di);
        while (di == d || !board[p.getX()][p.getY()].estAccessible()) {
            di = Direction.randomDirection();
            p = posDeDirection(di);
        }
        return di;
    }

    public abstract CompFant copy();

    public abstract void decomposer(List<CompFant> listCompFant, Case[][] board);

    public abstract int nbrViesReset();

}
