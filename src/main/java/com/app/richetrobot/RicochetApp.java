package com.app.richetrobot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RicochetApp extends Application {

    RicochetController controller;
    GameLogic game = new GameLogic();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(RicochetApp.class.getResource("small-prototype.fxml"));
        Scene scene = new Scene(loader.load(), 1200, 900);
        /*AnchorPane root = new AnchorPane();
        Scene gameScene = new Scene(root,1200,900);*/
        controller = loader.getController();
        stage.setTitle("Ricochet Robot");
        stage.setScene(scene);
        stage.show();
        //game.initialise(controller.grid.getChildren());
    }



    public static void main(String[] args) {
        launch();
        RicochetApp myApp = new RicochetApp();

    }
}
