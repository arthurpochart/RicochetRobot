package com.app.richetrobot;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Robot {

    private Node image;
    private int x;
    private int y;

    public Robot(ImageView image, int x, int y){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY() {
        return y;
    }



    public void setImage(ImageView image){
        this.image = image;
    }

    public Node getImage(){
        return this.image;
    }

    public enum Direction{
        NORTH,EAST,WEST,SOUTH
    }

}
