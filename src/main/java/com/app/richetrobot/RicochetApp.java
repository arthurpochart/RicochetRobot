package com.app.richetrobot;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;

import java.io.IOException;

public class RicochetApp extends Application {
    private Stage generalstage;

    @Override
    public void start(Stage stage) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        new AudioPlayer().play();
        generalstage = stage;
        //For example
        Game.start();

        /*AnchorPane root = new AnchorPane();
        Scene gameScene = new Scene(root,1200,900);*/
        stage.setScene(menuScene());
        stage.setTitle("RicochetRobot");
        stage.show();

    }
    public Scene menuScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(RicochetApp.class.getResource("menu-scene.fxml"));
        AnchorPane menuroot = loader.load();
        Button createAccountButton = new Button("Jouer!");
        createAccountButton.setLayoutX(300);
        createAccountButton.setLayoutY(300);
        createAccountButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                try {
                    generalstage.setScene(gameScene());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        menuroot.getChildren().add(createAccountButton);
        return new Scene(menuroot);
    }

    @FXML
    public Scene gameScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(RicochetApp.class.getResource("main-scene.fxml"));
        AnchorPane root = loader.load();
        Scene prototypeScene = new Scene(root);
        return prototypeScene;
    }
    public static void main(String[] args) {
        launch();

    }
}
