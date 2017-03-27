package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import Controller.Direction;

public class Game extends Observable {

    private PacMan pacman;
    private final int NBR_FANTOME = 4;
    private List<Position> listPosFant = new LinkedList<>();
    private Case[][] board = new Case[TAB.length][TAB[0].length];
    private List<CompFant> listFant = new LinkedList<>();
    private static Gardien g=new Gardien();
    private boolean fin=false;
    private static  int NBR_GOMME;
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

    Memento createMemento() {
        MementoImpl mem = new MementoImpl();
        mem.setPacman(pacman);
        mem.setListFant(listFant);
        mem.setBoard(board);
        return mem;
    }

    void setMemento(Memento m) {
           
        this.listFant=m.getListFant();
        this.board=m.getBoard();
        this.pacman=m.getPacman();
        
        
    }

    class MementoImpl implements Memento {

        private List<CompFant> listFantM = new LinkedList<>();

        private PacMan pacmanM;
        private Case[][] boardM;

        @Override
        public void setPacman(PacMan p) {
            this.pacmanM = new PacMan(p);
        }

        @Override
        public void setBoard(Case[][] board) {
            boardM=new Case[board.length][board[0].length];
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    this.boardM[i][j] = board[i][j].copy();
                }
            }
        }

        @Override
        public void setListFant(List<CompFant> lf) {
            for (CompFant f : lf) {
                this.listFantM.add(f.copy());
            }
        }
    

    @Override
    public PacMan getPacman() {
        return pacmanM;
    }

    @Override
    public Case[][] getBoard() {
        return this.boardM;
    }

    @Override
    public List<CompFant> getListFant() {
       return this.listFantM;
    }

}

public Game() {

        for (int i = 0; i < TAB.length; ++i) {
            for (int j = 0; j < TAB[i].length; ++j) {

                choixElement(TAB[i][j], new Position(i, j));
            }
        }
        for (int k = 0; k < NBR_FANTOME; ++k) {
            randomFantome();
        }
        for(int i=0 ; i<5; ++i){
            g.ajouteMemento(this.createMemento());
        }
    }

    private void randomFantome() {

        Random g = new Random();
        Position pos = listPosFant.remove(g.nextInt(listPosFant.size()));
        listFant.add(new Fantome(pos));
    }

    private void choixElement(int caseInt, Position pos) {

        switch (caseInt) {

            case (1):
                board[pos.getX()][pos.getY()] = new Mur();
                break;
            case (2):
                pacman = new PacMan(pos);
                board[pos.getX()][pos.getY()] = new CaseVide();
                break;
            case (4):
                board[pos.getX()][pos.getY()] = new Pacgomme();
                ++NBR_GOMME;
                break;
            case (5):
                board[pos.getX()][pos.getY()] = new Fruit();

                break;
            case (6):
                board[pos.getX()][pos.getY()] = new Champignon();

                break;
            default:
                listPosFant.add(pos);
                board[pos.getX()][pos.getY()] = new CaseVide();
                break;

        }
    }

    public void setChangeAndNotify(Object obj) {
        setChanged();
        notifyObservers(obj);
    }

    public boolean finDePartie() {
        return pacman.nbrFantManger() == 0 || pacman.nbrViesRestante() <= 0 || nbrGommeRestant()==0 || fin==true;
    }
    public void setFinDePartie(boolean b){
        this.fin=b;
    }
    public int nbrGommeRestant(){
        return NBR_GOMME-pacman.nbrGommeRestant();
    }
    public void deplacerPacman() {
        pacman.choixDeplacement(this);
        setChangeAndNotify(this);

    }

    public void deplacerFantome() {

        for (int i = 0; i < listFant.size(); ++i) {
            listFant.get(i).choixDeplacement(this);
            setChangeAndNotify(this);

        }

    }

    public int getLongeurBoard() {
        return board.length;
    }

    public int getLargeurBoard() {
        return board[0].length;
    }

    public List<CompFant> getFantomes() {
        return listFant;
    }

    public Position getPacmanPosition() {
        return pacman.getPosition();
    }

    public Case[][] getBoard() {
        return board;
    }

    public PacMan getPacman() {
        return pacman;
    }

    public void setDirectionPacman(Direction d) {
        pacman.setDirectionPacman(d);
    }

    public String ScoreViesRestante() {

        return "Vies restante : " + pacman.nbrViesRestante()
                + " Score : " + pacman.score() + " " + " nombre Gommes Restants: "
                + pacman.nbrGommeRestant()+ " nombre Total : " + 226;
    }

    public CompFant getFantome(Position pos) {
        for (int i = 0; i < listFant.size(); ++i) {
            if (listFant.get(i).getPosFant().equals(pos)) {
                return listFant.get(i);
            }
        }
        return null;
    }

    public void decomposer() {
        for (int i = 0; i < listFant.size(); ++i) {

            listFant.get(i).decomposer(listFant, board);
        }
    }
    public Gardien getGardien(){
        return g;
    }
    
}
