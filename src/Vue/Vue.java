package Vue;

import Controller.Direction;
import Model.Game;
import Model.Labyrinthe;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Vue implements Observer{
    private static final Vue VUE =new Vue();
    
    public static Vue getInstance(){
        return VUE;
    }
    private Vue(){}

    public static void affiche(Labyrinthe lab) {
        String boardaff = "";
        for (int i = 0; i < lab.getBoard().length; ++i) {
            for (int j = 0; j < lab.getBoard()[i].length; ++j) {

                if (lab.getBoard()[i][j].estUnPerso()) {
                    boardaff += lab.getBoard()[i][j].getPerso().toString();
                } else if (lab.getBoard()[i][j].estUnElement()) {
                    boardaff += lab.getBoard()[i][j].getElem().toString();
                } else {
                    boardaff += lab.getBoard()[i][j].toString();
                }
            }
            boardaff += "\n";
        }
        System.out.println(boardaff);

    }
   
    private static int trySaisirChoixDirection() {

        return rangeValidationSaisie(Direction.values().length);
    }

    private static int rangeValidationSaisie(int nMax) {
        int choixDirection = nombreSaisi();
        if (choixDirection < 0 || choixDirection > nMax) {
            return -1;
        }
        return choixDirection;
    }

    private static int nombreSaisi() {
        int entree = 0;
        Scanner sc = new Scanner(System.in);
        boolean entreeOK = false;
        while (!entreeOK) {
            try {
                entree = Integer.parseInt(sc.next());
                entreeOK = true;
            } catch (NumberFormatException e) {
                entreeIncorrecte();
            }
        }
        return entree;
    }

    public static void entreeIncorrecte() {
       affDirection();
    }

    public static void affMsg(String msg) {
        System.out.println(msg);
    }
    
     public static Direction saisirChoixDirection() {
        int choixInt = trySaisirChoixDirection();
        while (choixInt == -1) {
            entreeIncorrecte();
            choixInt = trySaisirChoixDirection();
        }
        return Direction.getByInt(choixInt);
    }
    public static void affDirection(){
        StringBuilder sb =new StringBuilder("\nDirection\n");
        for(Direction d :Direction.values()){
            sb.append(d.numero());
            sb.append(" : ");
            sb.append(d.toString());
           sb.append("  ");
        }
        affMsg(sb.toString());
    }

    @Override
    public void update(Observable obs, Object arg) {
       Game game=(Game)obs;
       affiche(game.getLab());
    }
    
}
