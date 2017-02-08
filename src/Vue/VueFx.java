package Vue;

import Model.Fruit;
import Model.Game;
import Model.PacMan;
import Model.Pacgomme;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VueFx implements Observer {

    private Text textScore;
   

    private final static Canvas canvas = new Canvas();
    private static final int TAILLE = 20;

    GraphicsContext gc;

    public VueFx(Stage stage, Game game) {
        start(stage, game);
        UpdateScore(textScore, game);
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    private void start(Stage primaryStage, Game game) {
        textScore = new Text(20, 516, "Point : " + game.ScoreViesRestante());
        gc = canvas.getGraphicsContext2D();
        Pane root = new Pane() {
            @Override
            protected void layoutChildren() {

                canvas.setWidth(23 * 20);
                canvas.setHeight(25 * 20);
                gc.setFill(Color.BLACK);

                choixElem(gc, game);
            }

        };
        root.getChildren().add(canvas);
        root.getChildren().add(textScore);
        Scene scene = new Scene(root, 445, 510);

        primaryStage.setTitle("Pacman");
        primaryStage.getIcons().add(new Image("file:images/pacman_normal.png"));

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        canvas.setFocusTraversable(true);
        canvas.requestFocus();

    }

    public void choixElem(GraphicsContext gc, Game game) {
        for (int i = 0; i < game.getLab().getBoard().length; ++i) {
            for (int j = 0; j < game.getLab().getBoard()[i].length; ++j) {
                if (game.getLab().getBoard()[i][j].estUnMur()) {
                    VueMur.paintOn(gc, i, j);
                } else if (game.getLab().getBoard()[i][j].estUnPerso()) {
                    if((game.getLab().getBoard()[i][j].getPerso() instanceof PacMan)){
                        VuePacMan.paintOn(gc, i, j);
                    }else{
                        VueFant.paintOn(gc, i, j,game);
                    }
                } else if (game.getLab().getBoard()[i][j].estUnAliment()) {
                    if((game.getLab().getBoard()[i][j].getAlim()instanceof Fruit)){
                        VueFruit.paintOn(gc, i, j);
                    }else if(game.getLab().getBoard()[i][j].getAlim()instanceof Pacgomme){
                        VuePacGom.paintOn(gc, i, j);
                    }else{
                        VueChampi.paintOn(gc, i, j);
                    }
                } else if (game.getLab().getBoard()[i][j].isEmpty()) {
                    VueVide.paintOn(gc, i, j);
                }

            }
        }
    }

    

    private void UpdateScore(Text textScore, Game game) {
        textScore.setText(game.ScoreViesRestante());

    }

    @Override
    public void update(Observable obs, Object obj) {
        Game game = (Game) obs;
        choixElem(gc, game);
        UpdateScore(textScore, game);
    }

}
