package com.app.richetrobot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

        for(Node node: grid.getChildren()){
            Case newCase = new Case(node);
            Game.board[newCase.getX()][newCase.getY()] = newCase;
        }

        //Game.setSIZE((int) Math.sqrt(grid.getChildren().size()-2));
        addRobot(Token.Color.BLUE);
        addRobot(Token.Color.GREEN);
        addRobot(Token.Color.RED);
        addRobot(Token.Color.YELLOW);

        grid.add(
                new ImageView( new Image(
                        Game.context.getTarget().getColor() + "_target.png",
                        30, 30, false, true
                ) ),
                Game.context.getTarget().getX(),
                Game.context.getTarget().getY()
        );
        System.out.println("Controller Initialized");
    }

    public RicochetController(){

    }

    private void addRobot(Token.Color color){
        Token robot = Game.context.getRobots().get(color);
        ImageView robotGui = new ImageView( new Image(
                color.name() + "_robot.png",
                30, 30, false, true
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
        Token robottoMove = Game.context.selectedRobot;

        int[] destination = Game.context.getDestination(Game.Direction.UP);
        robottoMove.setPosition(destination[0],destination[1]);

        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());

    }
    @FXML
    private void clickDown(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;

        int[] destination = Game.context.getDestination(Game.Direction.DOWN);
        robottoMove.setPosition(destination[0],destination[1]);

        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());
        System.out.println("Down Clicked");
    }
    @FXML
    private void clickLeft(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;

        int[] destination = Game.context.getDestination(Game.Direction.LEFT);
        robottoMove.setPosition(destination[0],destination[1]);

        GridPane.setConstraints(robottoMove.getImage(),robottoMove.getX(),robottoMove.getY());
        System.out.println("Left Clicked");
    }
    @FXML
    private void clickRight(MouseEvent event) {
        Token robottoMove = Game.context.selectedRobot;

        int[] destination = Game.context.getDestination(Game.Direction.RIGHT);
        robottoMove.setPosition(destination[0],destination[1]);

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
    @FXML
    private TextField Score1;
    public void afficheScore1(ActionEvent event){

    }
    @FXML
    private TextField Score2;
    public void afficheScore2(ActionEvent event){

    }
    @FXML
    private TextField temps;
    public void afficheTemps(ActionEvent event){

    }


}