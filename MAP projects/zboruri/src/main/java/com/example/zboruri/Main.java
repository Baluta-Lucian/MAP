package com.example.zboruri;

import com.example.zboruri.controller.LoginController;
import com.example.zboruri.repository.RepositoryDbClienti;
import com.example.zboruri.repository.RepositoryDbPurchasedTicket;
import com.example.zboruri.repository.RepositoryDbZboruri;
import com.example.zboruri.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    private String url = "jdbc:postgresql://localhost:5432/zboruri";
    private String username = "postgres";
    private String password = "CripiFace2";

    @Override
    public void start(Stage stage) throws IOException {

        RepositoryDbZboruri repoZboruri = new RepositoryDbZboruri(url, username, password);
        RepositoryDbClienti repoClienti = new RepositoryDbClienti(url, username, password);
        RepositoryDbPurchasedTicket repoTichete = new RepositoryDbPurchasedTicket(url, username, password);
        Service service = new Service(repoZboruri, repoClienti, repoTichete);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

        LoginController loginController = fxmlLoader.getController();
        loginController.setService(service);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
