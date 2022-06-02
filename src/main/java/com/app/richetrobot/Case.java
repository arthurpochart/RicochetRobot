package com.app.richetrobot;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.decoration.GraphicDecoration;

public class Case {

    private Node image;
    private int x;
    private int y;
    public boolean NORTH;
    public boolean SOUTH;
    public boolean WEST;
    public boolean EAST;

    public Case(Node image) {
        if (image instanceof ImageView) {
            this.image = image;
        }
        String styleClass = "none";
        try {
            styleClass = image.getStyleClass().get(1);
        } catch (Exception e) {
            this.NORTH = false;
            this.WEST = false;
            this.SOUTH = false;
            this.EAST = false;
        }

        if (styleClass.equals("top-right")) {
            this.NORTH = true;
            this.EAST = true;
        } else if (styleClass.equals("bottom-right")) {
            this.SOUTH = true;
            this.EAST = true;
        } else if (styleClass.equals("bottom-left")) {
            this.SOUTH = true;
            this.WEST = true;
        } else if (styleClass.equals("top-left")) {
            this.NORTH = true;
            this.WEST = true;
        } else if (styleClass.equals("left-right")) {
            this.EAST = true;
            this.WEST = true;
        } else if (styleClass.equals("bottom")) {
            this.SOUTH = true;
        } else if (styleClass.equals("top")) {
            this.NORTH = true;
        } else if (styleClass.equals("right")) {
            this.EAST = true;
        } else if (styleClass.equals("left")) {
            this.WEST = true;
        } else if (styleClass.equals("top-bottom")) {
            this.SOUTH = true;
            this.NORTH = true;
        }


        if (GridPane.getColumnIndex(image) == null) {
            this.x = 0;
        }
        if (GridPane.getRowIndex(image) == null) {
            this.y = 0;
        } else {
            this.x = GridPane.getColumnIndex(image);
            this.y = GridPane.getRowIndex(image);
        }


    }

    public boolean containsRobot(){
        for (Token robot: Game.robots.values()){
            if (robot.getX()==this.x&&robot.getY()==this.y){
                return true;
            }
        }
        return false;
    }

    public boolean containsTarget(){
        if (Game.target.getX() == this.x && Game.target.getY() == this.y){
            return  true;
        }
        return false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public ImageView getImage(){
        return (ImageView) this.image;
    }
    private enum Wall{
        NORTH,EAST,WEST,SOUTH
    }

    int size = 64;

    private Robot robot;


}
