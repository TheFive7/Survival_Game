package com.game.survivalgame.objects;

import com.game.survivalgame.Direction;
import javafx.scene.shape.Circle;

public class Player extends Circle {

    int x;
    int y;
    int xVelocity;
    int yVelocity;
    Direction direction;

    public Player(){
        super();
        x = 400;
        y = 400;
        xVelocity = 0;
        yVelocity = 0;
        setCenterX(x);
        setCenterY(x);
        setRadius(30);
        direction = Direction.UP;
    }

    public void update(){
        x += xVelocity;
        y += yVelocity;
        setCenterX(x);
        setCenterY(y);
    }

    public void moveUp() {
        xVelocity = 0;
        yVelocity = -5;
        direction = Direction.UP;
    }

    public void moveLeft() {
        xVelocity = -5;
        yVelocity = 0;
        direction = Direction.LEFT;
    }

    public void moveDown() {
        xVelocity = 0;
        yVelocity = 5;
        direction = Direction.DOWN;
    }

    public void moveRight() {
        xVelocity = 5;
        yVelocity = 0;
        direction = Direction.RIGHT;
    }

    public void stop(){
        xVelocity = 0;
        yVelocity = 0;
    }

    public Direction getDirection(){
        return direction;
    }
}
