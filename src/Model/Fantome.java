package Model;

public class Fantome extends Personnage {

    Position posFant, posInit;
    Direction direction;

    public Fantome(Position p) {
        posFant = p;
        posInit = p;
        this.direction = Direction.randomDirection();
    }

    @Override
    public String toString() {
        return " F ";
    }

    public void choixDeplacement(Case[][] board, PacMan pacman) {
        switch (direction) {
            case NORD:
                Position posH = new Position(posFant.getX() - 1, posFant.getY());
                deplacer(posH, pacman,board);
                break;
            case SUD:
                Position posB = new Position(posFant.getX() + 1, posFant.getY());
                deplacer(posB, pacman, board);
                break;
            case OUEST:
                Position posD = new Position(posFant.getX(), posFant.getY() + 1);
                deplacer(posD, pacman, board);
                break;
            case EST:
                Position posG = new Position(posFant.getX(), posFant.getY() - 1);
                deplacer(posG, pacman, board);
                break;
        }

    }
    public void deplacer(Position pos ,PacMan pacman,Case [][] board){
        while(board[pos.getX()][pos.getY()].estAccessible() ){
            posFant=pos;
            
             choixDeplacement(board, pacman);
             
        }
        this.direction=Direction.randomDirection();
        choixDeplacement(board, pacman);
               
    }

    public void setPosition(Position pos) {
        this.posFant = pos;
    }

    public Position getPosFant() {
        return posFant;
    }

    public void initCase() {
        posFant = posInit;
    }

}
