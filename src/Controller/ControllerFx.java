package Controller;

import Model.Game;
import Model.Position;
import Vue.VueFx;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.EventHandler;

import javafx.scene.canvas.Canvas;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerFx extends Application {

    private static final Game game = new Game();
    private final Canvas root = VueFx.getCanvas();

    @Override
    public void start(Stage stage) throws Exception {
        VueFx vue = new VueFx(stage, game);
        deplacement();
        game.addObserver(vue);
//        joueFantome(game);

    }
//    private void joueFantome(Game game){
//         Timeline timeline = new Timeline(new KeyFrame(
//                Duration.millis(100),
//                ae -> actionPeriodique(game))
//        );
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();                
//    }
//    // private void actionPeriodique(Game game) {
//     //   game.deplacerFantome(Direction.randomDirection());
//   // }
    
    private void deplacement() {

        this.root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (game.finDePartie()) {
                    Platform.exit();
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    dirigerEst();
                   

                }
                if (event.getCode() == KeyCode.LEFT) {

                    
                     dirigerOuest();
                }
                if (event.getCode() == KeyCode.UP) {
                    dirigerNord();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    
                    dirigerSud();
                }

            }
        });
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

    public static void main(String[] args) {
        launch(args);
    }

}