package com.game.survivalgame;

import com.game.survivalgame.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public View view;

    @Override
    public void start(Stage stage) {
        Model model = new Model();
        view = new View(model);
        Controller controller = new Controller(model, view);

        Scene gameScene = new Scene(view.root, model.width, model.height);
        stage.setScene(gameScene);
        stage.show();

        controller.startGame();
    }

    public static void main(String[] args) {
        launch();
    }
}
