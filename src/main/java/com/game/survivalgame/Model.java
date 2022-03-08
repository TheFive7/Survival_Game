package com.game.survivalgame;

import com.game.survivalgame.objects.Flower;
import com.game.survivalgame.objects.Player;

import java.util.ArrayList;
import java.util.List;

public class Model {

    // SETTINGS
    public long lastFrame;
    public final int width;
    public final int height;

    // OBJECTS
    public Player player;
    public List<Flower> flowers = new ArrayList<>();

    public Model() {
        width = 800;
        height = 800;
        lastFrame = -1;
    }

    public void startGame(){
        player = new Player();

        // FLOWERS
        for (int i = 0; i < 100; i++){
            flowers.add(new Flower(this));
        }
    }

    public void update(){
        player.update();

        for (Flower flower : flowers){
            if (flower.active){
                flower.update();
            }
        }
    }
}
