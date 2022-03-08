package com.game.survivalgame.controller;

import com.game.survivalgame.Direction;
import com.game.survivalgame.Model;
import com.game.survivalgame.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControllerKeyboard implements EventHandler<KeyEvent> {

    protected final Model model;
    protected final View view;
    protected final Controller control;
    KeyCode lastKey;

    public ControllerKeyboard(Model model, View view, Controller control) {
        this.model = model;
        this.view = view;
        this.control = control;
        lastKey = KeyCode.Z;

        view.root.setFocusTraversable(true);
        view.root.requestFocus();
        view.root.setOnKeyPressed(this);

        // Keys
        view.root.setOnKeyReleased(event -> {
            // Left
            if (event.getCode() == KeyCode.Z && model.player.getDirection() == Direction.UP) {
                control.stopPlayer();
                // Right
            } else if (event.getCode() == KeyCode.Q && model.player.getDirection() == Direction.LEFT) {
                control.stopPlayer();
            } else if (event.getCode() == KeyCode.S && model.player.getDirection() == Direction.DOWN) {
                control.stopPlayer();
            } else if (event.getCode() == KeyCode.D && model.player.getDirection() == Direction.RIGHT) {
                control.stopPlayer();
            }
        });
    }

    public void handle(KeyEvent arg0) {

        // System.out.println("keycode = "+arg0.getCode());

        // BASE
        if (arg0.getCode() == KeyCode.Z) {
            control.moveUp();
            lastKey = KeyCode.Z;
        }
        if (arg0.getCode() == KeyCode.Q) {
            control.moveLeft();
            lastKey = KeyCode.Q;
        }
        if (arg0.getCode() == KeyCode.S) {
            control.moveDown();
            lastKey = KeyCode.S;
        }
        if (arg0.getCode() == KeyCode.D) {
            control.moveRight();
            lastKey = KeyCode.D;
        }
    }
}
