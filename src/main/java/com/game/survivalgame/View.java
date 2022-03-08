package com.game.survivalgame;

import com.game.survivalgame.objects.Flower;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class View {

    public final Group root;
    final Model model;

    Pane paneGame;

    public View(Model model) {
        this.model = model;
        root = new Group();

        paneGame = new Pane();
        paneGame.setPrefSize(model.width, model.height);
        root.getChildren().add(paneGame);
    }

    /**
     * Start the game
     */
    public void startGame() {
        root.getChildren().clear();
        root.getChildren().add(paneGame);

        for (Flower flower : model.flowers) {
            paneGame.getChildren().add(flower);
        }

        // PANEGAME
        paneGame.getChildren().add(model.player);
    }
}
