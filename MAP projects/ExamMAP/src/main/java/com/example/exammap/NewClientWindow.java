package com.example.exammap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NewClientWindow {



    public static void display() throws IOException {
        Stage primaryStage = new Stage();
        //asta nu te lasa sa treci la window anterior pana nu
        //il inchizi pe asta (initModality();)
        FXMLLoader fxmlLoader2 = new FXMLLoader(NewClientWindow.class.getResource("new-client-window.fxml"));
        Scene secondScene = new Scene(fxmlLoader2.load(), 800, 500);
        primaryStage.setTitle("A doua functionalitate");
        primaryStage.setScene(secondScene);
        primaryStage.show();
    }
}
