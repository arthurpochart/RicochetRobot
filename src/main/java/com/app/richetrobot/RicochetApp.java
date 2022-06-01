package com.app.richetrobot;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RicochetApp extends Application {

        private GridPane plateau;


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(RicochetApp.class.getResource("small-prototype.fxml"));
        AnchorPane root = loader.load();
        Scene prototypeScene = new Scene(root, 1200, 900);
        /*AnchorPane root = new AnchorPane();
        Scene gameScene = new Scene(root,1200,900);*/
        stage.setScene(prototypeScene);
        stage.setTitle("RicochetRobot");




        plateau = (GridPane) root.getChildren().get(1);

        stage.show();




    }



    public static void main(String[] args) {
        launch();

    }
}
