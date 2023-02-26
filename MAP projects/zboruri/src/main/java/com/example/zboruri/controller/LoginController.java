package com.example.zboruri.controller;

import com.example.zboruri.Main;
import com.example.zboruri.domain.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.zboruri.service.Service;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    Service service;

        int i = 1;

    public void setService(Service service){
        this.service = service;
    }

    @FXML
    Button loginBtn;

    @FXML
    PasswordField passwordField;

    @FXML
    TextField usernameField;

    @FXML
    public void onLoginButtonPush(ActionEvent actionEvent) throws IOException {
        if(usernameField.getText().length() != 0 && passwordField.getText().length()!=0)
        {
        Client client = new Client(usernameField.getText(), passwordField.getText());
        System.out.println(client);
        service.saveClient(client);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("zboruri-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200,800);
        Stage stage = new Stage();
        ZboruriController zboruriController = fxmlLoader.getController();
        zboruriController.setService(service);
        zboruriController.setId(i);
        zboruriController.setUserData(client);

        stage.setTitle(client.getName());
        stage.setUserData(client);
        i = i + 1;
        stage.setScene(scene);
        stage.show();
        }

    }




}
