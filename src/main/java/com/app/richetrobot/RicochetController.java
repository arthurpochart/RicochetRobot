package com.app.richetrobot;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.GRAY;

public class RicochetController implements Initializable {

    @FXML
    ImageView robob;
    @FXML
    GridPane grid;
    @FXML
    AnchorPane scene;
    @FXML
    ImageView upArrow;
    @FXML
    ImageView downArrow;
    @FXML
    ImageView leftArrow;
    @FXML
    ImageView rightArrow;

    Robot mainRobot = new Robot(robob, 2,3);

    public RicochetController(){

    }



    @FXML
    private void clickUp(MouseEvent event) {
        System.out.println("Up Clicked");
       /* System.out.println("Z pressed");
        StackPane destNode = (StackPane) getNodeFromGridPane(grid,mainRobot.getX(),mainRobot.getY()+1);
        destNode.getChildren().add(robob);*/
    }
    @FXML
    private void clickDown(MouseEvent event) {
        System.out.println("Down Clicked");
    }
    @FXML
    private void clickLeft(MouseEvent event) {
        System.out.println("Left Clicked");
    }
    @FXML
    private void clickRight(MouseEvent event) {
        System.out.println("Right Clicked");

    }

    // Method for finding rectangle in gridpane:
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren())
            if (GridPane.getColumnIndex(node) != null
                    && GridPane.getColumnIndex(node) != null
                    && GridPane.getRowIndex(node) == row
                    && GridPane.getColumnIndex(node) == col)
                return node;
        return null;
    }

    public void clickRectEvent(MouseEvent mouseEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller Initialized");
    }
}