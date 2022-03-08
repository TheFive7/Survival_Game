package com.game.survivalgame.objects;

import com.game.survivalgame.Model;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Flower extends Rectangle {
    Model model;

    public boolean active;

    public Flower(Model model){
        super(5,5);
        this.model = model;
        active = true;
        Random r = new Random();
        setX(r.nextInt(model.height));
        setY(r.nextInt(model.width));
        setFill(Color.PINK);
    }

    public void update(){
        Shape inter = Shape.intersect(model.player, this);
        Bounds b = inter.getBoundsInLocal();

        if (b.getWidth() != -1) {
            for (Flower flower : model.flowers){
                if (flower.equals(this)){
                    flower.active = false;
                    flower.setFill(Color.WHITE);
                }
            }
            model.player.setRadius(model.player.getRadius() + 1);
        }
    }
}
