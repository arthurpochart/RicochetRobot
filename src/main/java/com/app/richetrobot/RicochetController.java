package com.app.richetrobot;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RicochetController implements Initializable {


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

    Token mainRobot;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Game.setSIZE((int) Math.sqrt(grid.getChildren().size()-2));
        addRobot(Token.Color.BLUE);
        addRobot(Token.Color.GREEN);
        addRobot(Token.Color.RED);
        addRobot(Token.Color.YELLOW);
        System.out.println("Controller Initialized");
    }

    public RicochetController(){

    }

    private void addRobot(Token.Color color){
        Token robot = Game.context.getRobots().get(color);
        ImageView robotGui = new ImageView( new Image(
                color.name() + "_robot.png",
                90, 90, false, true
        ) );
        robotGui.setOnMouseClicked
                (event -> Game.context.processSelectRobot(color));
        grid.add(robotGui, robot.getX(), robot.getY());
        // Association de l' "ImageView" avec le robot stocké dans le jeu
        robot.setImage(robotGui);
        //mainRobot = new Token(new ImageView(new Image("robot.png")), Token.Color.BLUE,3,2);
    }

    @FXML
    private void clickUp(MouseEvent event) {

        System.out.println("Up Clicked");
        //Node destNode = getNodeFromGridPane(grid,mainRobot.getX(),mainRobot.getY()-1);
        Token robottoMove = Game.context.selectedRobot;
        robottoMove.setPosition(robottoMove.getX(),robottoMove.getY()-1);
        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());

    }
    @FXML
    private void clickDown(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;
        robottoMove.setPosition(robottoMove.getX(),robottoMove.getY()+1);
        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());
        System.out.println("Down Clicked");
    }
    @FXML
    private void clickLeft(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;
        robottoMove.setPosition(robottoMove.getX()-1,robottoMove.getY());
        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());
        System.out.println("Left Clicked");
    }
    @FXML
    private void clickRight(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;
        robottoMove.setPosition(robottoMove.getX()+1,robottoMove.getY());
        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());
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


}