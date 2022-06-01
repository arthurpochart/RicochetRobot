package com.app.richetrobot;

import javafx.scene.image.ImageView;

public class Robot {

    private ImageView image;
    private int x;
    private int y;

    public Robot(ImageView image, int x, int y){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return y;
    }

    public enum Direction{
        NORTH,EAST,WEST,SOUTH
    }

    public void move(Direction direction){

    }
}
