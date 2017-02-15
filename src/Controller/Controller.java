package Controller;

import Model.Game;
import Vue.Vue;

public class Controller {

    private Game game;

    public static void main(String[] args) {
        Controller ctrl = new Controller();

        ctrl.jouerPartie();
    }

    public Controller() {

        game = new Game();
        game.addObserver(Vue.getInstance());

    }

    public void diriger() {
        Direction d = Vue.saisirChoixDirection();
        game.setDirectionPacman(d);
        game.deplacerPacman();
    }

    public void jouerPartie() {

        Vue.affDirection();
        do {
            Vue.affiche(game);
//            Vue.affMsg(game.ScoreViesRestante());
            diriger();
        } while (!game.finDePartie());
        Vue.affMsg("fin de partie : nombre de vies epuisées ou tout les fantomes mangés : ");

    }

}
