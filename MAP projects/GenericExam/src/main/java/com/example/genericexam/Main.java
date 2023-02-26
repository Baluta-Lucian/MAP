package com.example.genericexam;

import com.example.genericexam.controller.MainController;
import com.example.genericexam.repository.RepositoryDbIntrebari;
import com.example.genericexam.service.ServiceProfesor;
import com.example.genericexam.service.ServiceStudent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private String url = "jdbc:postgresql://localhost:5432/genericexamdb";
    private String username = "postgres";
    private String password = "CripiFace2";

    private String s1;
    private String s2;
    private String s3;

    @Override
    public void start(Stage stage) throws IOException {
        RepositoryDbIntrebari repoIntrebari = new RepositoryDbIntrebari(url, username, password);
        ServiceStudent serviceStudent = new ServiceStudent(repoIntrebari);
        ServiceProfesor serviceProfesor = new ServiceProfesor(repoIntrebari);

//        RepositoryDbZboruri repoZboruri = new RepositoryDbZboruri(url, username, password);
//        RepositoryDbClienti repoClienti = new RepositoryDbClienti(url, username, password);
//        RepositoryDbPurchasedTicket repoTichete = new RepositoryDbPurchasedTicket(url, username, password);
//        Service service = new Service(repoZboruri, repoClienti, repoTichete);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

//        LoginController loginController = fxmlLoader.getController();
//        loginController.setService(service);

        List<String> params = getParameters().getRaw();
        MainController mainController = fxmlLoader.getController();
        mainController.setService(serviceStudent, serviceProfesor);
        mainController.passArgs(params.get(0), params.get(1), params.get(2));

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args){



        launch(args);


    }
}
