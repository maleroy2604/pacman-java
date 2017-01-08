package Controller;

import Model.Game;

import Model.Position;

import Vue.Vue;
import java.util.Scanner;

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
        Direction d = null;
        d = Vue.saisirChoixDirection();
        switch (d) {
            case NORD:
                dirigerNord();
                break;
            case SUD:
                dirigerSud();
                break;
            case EST:
                dirigerEst();
                break;
            case OUEST:
                dirigerOuest();
                break;
        }
    }

    private void dirigerNord() {
        Position posH = new Position(game.getLab().getPosCourante().getX() - 1, game.getLab().getPosCourante().getY());
        game.deplacer(posH);
    }

    private void dirigerSud() {
        Position posB = new Position((game.getLab().getPosCourante().getX()) + 1, game.getLab().getPosCourante().getY());
        game.deplacer(posB);

    }

    public void dirigerEst() {
        Position posD = new Position(game.getLab().getPosCourante().getX(), (game.getLab().getPosCourante().getY()) + 1);
        game.deplacer(posD);
    }

    public void dirigerOuest() {
        Position posG = new Position(game.getLab().getPosCourante().getX(), (game.getLab().getPosCourante().getY()) - 1);
        game.deplacer(posG);
    }

    public void jouerPartie() {

        Vue.affDirection();
        do {
            Vue.affiche(game.getLab());
            Vue.affMsg(game.ScoreViesRestante());
            diriger();
        } while (!game.finDePartie());
        Vue.affMsg("fin de partie : nombre de vies epuisées ou tout les fantomes mangés : ");

    }
}
