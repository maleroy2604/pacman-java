package Vue;

import Controller.Direction;
import Model.CompFant;
import Model.Fantome;

import Model.Game;
import Model.Position;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Vue implements Observer{
    private static final Vue VUE =new Vue();
    
    public static Vue getInstance(){
        return VUE;
    }
    private Vue(){}

    private static boolean  verifPos(List<CompFant> listFant,Position pos){
        for(CompFant fant :listFant){
            if (fant.getPosFant().equals(pos))
                return true;
        }
        return false;
    }
     public static void affiche(Game game) {
        String boardaff = "";
        for (int i = 0; i < game.getLongeurBoard(); ++i) {
            for (int j = 0; j < game.getLargeurBoard(); ++j) {
                if(verifPos(game.getFantomes(),new Position(i, j))){
                    boardaff+=" F ";
                }else if(game.getPacmanPosition().equals(new Position(i, j))){
                    boardaff+=" P ";
                }else{
                    boardaff+=game.getBoard()[i][j].toString();
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
       affiche(game);
    }
    
}
