package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Main;
import org.example.domain.Organizator;
import org.example.service.ServiceOrganizator;
import org.example.service.ServiceParticipant;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button LoginBtn;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    private ServiceOrganizator serviceOrganizator;
    private ServiceParticipant serviceParticipant;

    public void setService(ServiceOrganizator serviceOrganizator, ServiceParticipant serviceParticipant){
        this.serviceOrganizator = serviceOrganizator;
        this.serviceParticipant = serviceParticipant;
    }


    @FXML
    void onButtonPush(ActionEvent event) throws IOException{
        if(usernameTextField.getText().equals(""))
            System.out.println("You must introduce your username!");
        else if (passwordTextField.getText().equals("")) {
            System.out.println("You must introduce your password!");
        }
        else{
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            Organizator organizator = new Organizator(username, password);
            if(serviceOrganizator.isValid(organizator)){
                System.out.println("You are logged in!");



                //@TODO open organizator view
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("organizator-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
                Stage stage = new Stage();
                OrganizatorController organizatorController = fxmlLoader.getController();
                organizatorController.setService(this.serviceOrganizator, this.serviceParticipant);

                stage.setTitle("Organizator");
                stage.setScene(scene);
                stage.show();

            }
            else{
                System.out.println("Wrong credentials!");
            }
        }
    }

}
