/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;


interface Memento {
    
    void setPacman(PacMan p);
    void setBoard(Case[][] board);
    void setListFant(List<CompFant> lf);
    PacMan getPacman();
    Case [][] getBoard();
    List<CompFant> getListFant();
}
