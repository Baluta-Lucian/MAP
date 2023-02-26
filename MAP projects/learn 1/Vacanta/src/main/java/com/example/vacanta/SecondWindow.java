package com.example.vacanta;

import com.example.vacanta.domain.Hotel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondWindow{


    public static void display(Hotel neededHotel) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setUserData(neededHotel);
        //asta nu te lasa sa treci la window anterior pana nu
        //il inchizi pe asta (initModality();)
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader2 = new FXMLLoader(SecondWindow.class.getResource("second-window.fxml"));
        Scene secondScene = new Scene(fxmlLoader2.load(), 800, 500);
        primaryStage.setTitle("A doua functionalitate");
        primaryStage.setScene(secondScene);
        primaryStage.show();
    }


}
