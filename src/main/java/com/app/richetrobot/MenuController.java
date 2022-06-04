package com.app.richetrobot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class MenuController implements Initializable {

    public MenuController(){

    }

    @FXML
    private Button deuxJoueurs;
    public void bouton2(ActionEvent event){

    }
    @FXML
    private Button troisJoueurs;
    public void bouton3(ActionEvent event){

    }
    @FXML
    private Button quatreJoueurs;
    public void bouton4(ActionEvent event){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Menu Initialized");
    }

}
