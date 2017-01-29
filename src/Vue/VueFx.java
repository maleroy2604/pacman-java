package Vue;

import Model.Game;

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
    private final Image pacman = new Image("file:images/pacman_normal.png");
    private final Image pacgom = new Image("file:images/boule-de-gomme.png");
    private final Image fruit = new Image("file:images/fruit.png");
    private final Image champignon = new Image("file:images/champignon.png");
    private final Image fantome = new Image("file:images/enemy_normal.png");
    private final Image vide = new Image("file:images/vide.png");
    
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
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
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
                if (game.getLab().getBoard()[i][j].estUnPerso()) {

                    ChoixImage(game.getLab().getBoard()[i][j].getPerso().toString(), gc, i, j, game);
                } else if (game.getLab().getBoard()[i][j].estUnAliment()) {
                    ChoixImage(game.getLab().getBoard()[i][j].getAlim().toString(), gc, i, j, game);
                } else if (game.getLab().getBoard()[i][j].isEmpty()) {
                    ChoixImage(game.getLab().getBoard()[i][j].toString(), gc, i, j, game);
                }

            }
        }
    }

    public void ChoixImage(String chaine, GraphicsContext gc, int i, int j, Game game) {
        switch (chaine) {
            case "   ":
                gc.drawImage(
                        vide,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
                break;
            case " F ":
                
                    gc.drawImage(
                            fantome,
                            j * 20,
                            i * 20,
                            TAILLE,
                            TAILLE
                    );
                
                break;
            case " P ":
                gc.drawImage(
                        pacman,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
                break;
            case " . ":
                gc.drawImage(
                        pacgom,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
                break;
            case " § ":
                gc.drawImage(
                        fruit,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
                break;
            case " C ":
                gc.drawImage(
                        champignon,
                        j * 20,
                        i * 20,
                        TAILLE,
                        TAILLE
                );
                break;

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
