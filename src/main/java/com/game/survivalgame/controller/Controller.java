package com.game.survivalgame.controller;

import com.game.survivalgame.Model;
import com.game.survivalgame.View;
import javafx.animation.AnimationTimer;

public class Controller {

    protected final Model model;
    protected final View view;
    protected final ControllerKeyboard keyboard;
    protected final AnimationTimer animator;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        keyboard = new ControllerKeyboard(model, view, this);

        // animation loop
        animator = new AnimationTimer() {

            @Override
            public void handle(long arg0) {
                if (model.lastFrame != -1) {
                    if ((arg0 - model.lastFrame) < 10000000) return;
                }
                model.lastFrame = arg0;
                model.update();
            }
        };
    }

    /**
     * Start the game
     */
    public void startGame() {
        model.startGame();
        view.startGame();
        view.root.setFocusTraversable(true);
        view.root.requestFocus();
        animator.start();
    }

    public void moveUp(){
        model.player.moveUp();
    }

    public void moveLeft(){
        model.player.moveLeft();
    }

    public void moveDown(){
        model.player.moveDown();
    }

    public void moveRight(){
        model.player.moveRight();
    }

    public void stopPlayer(){
        model.player.stop();
    }
}
