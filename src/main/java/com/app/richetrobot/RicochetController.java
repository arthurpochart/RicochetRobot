package com.app.richetrobot;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.GRAY;

public class RicochetController {

    @FXML
    GridPane grid;
    @FXML
    private ImageView robotImage;



    public void dragStartEvent(MouseEvent mouseEvent) {
        System.out.println(grid.getChildren());

    }

    public void clickRectEvent(MouseEvent mouseEvent) {

    }
}