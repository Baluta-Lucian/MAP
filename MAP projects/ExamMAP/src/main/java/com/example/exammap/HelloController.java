package com.example.exammap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button myClientButton;

    @FXML
    private Label welcomeText;

    @FXML
    protected void openNewWindow(){
        try{
            NewClientWindow.display();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}