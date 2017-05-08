
package Model;

import java.util.List;


interface Memento {
    PacMan getPacman();
    Case [][] getBoard();
    List<CompFant> getListFant();
}
