package com.app.richetrobot;

import javafx.scene.layout.StackPane;

public class Case extends StackPane {

    
    private enum Wall{
        NORTH,EAST,WEST,SOUTH
    }
    int size = 64;

    private Robot robot;
    private Position position;

    public Case(Wall wall){

    }
}
