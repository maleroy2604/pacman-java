package Controller;

import Model.Game;
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
        joueFantome();
        deplacement();
        game.addObserver(vue);

    }

    private void joueFantome() {

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(200),
                ae -> actionPeriodique())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void actionPeriodique() {
        if (game.finDePartie()) {
            Platform.exit();
        }
        game.deplacerFantome();
    }

    private void deplacement() {

        this.root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (game.finDePartie()) {
                    Platform.exit();
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    game.setDirectionPacman(Direction.EST);
                    game.deplacerPacman();

                }
                if (event.getCode() == KeyCode.LEFT) {
                    game.setDirectionPacman(Direction.OUEST);
                    game.deplacerPacman();
                }
                if (event.getCode() == KeyCode.UP) {
                    game.setDirectionPacman(Direction.NORD);
                    game.deplacerPacman();
                }
                if (event.getCode() == KeyCode.DOWN) {

                    game.setDirectionPacman(Direction.SUD);
                    game.deplacerPacman();
                }

            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
