package com.app.richetrobot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RicochetController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}