package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.LoginController;
import org.example.domain.Participant;
import org.example.domain.cm3;
import org.example.repository.OrganizatorDbRepository;
import org.example.repository.ParticipantDbRepository;
import org.example.service.ServiceOrganizator;
import org.example.service.ServiceParticipant;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.example.domain.cm3.A;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        Properties props=new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }
        OrganizatorDbRepository repoOrganizatori = new OrganizatorDbRepository(props);
        ServiceOrganizator serviceOrganizator = new ServiceOrganizator(repoOrganizatori);

        ParticipantDbRepository repoParticipanti = new ParticipantDbRepository(props);
        ServiceParticipant serviceParticipant = new ServiceParticipant(repoParticipanti);
//        System.out.println(Main.class.getResource("login-view.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);

        LoginController loginController = fxmlLoader.getController();
        loginController.setService(serviceOrganizator, serviceParticipant);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //@TODO
    //adauga fxml log4j
    public static void main(String[] args) {

        launch(args);
//        System.out.println("Hello world!");
//        //System.out.println(A.label); -> sout - 125
//        Properties props=new Properties();
//        try {
//            props.load(new FileReader("bd.config"));
//        } catch (IOException e) {
//            System.out.println("Cannot find bd.config "+e);
//        }
//
//        ParticipantDbRepository participantDbRepository = new ParticipantDbRepository(props);
//        participantDbRepository.add(new Participant("Horia", cm3.B, "Suzuki"));
//        for(Participant participant : participantDbRepository.findAll())
//            System.out.println(participant);
//
//        System.out.println("Toti participantii de la o echipa");
//        for(Participant participant : participantDbRepository.findByTeam("Suzuki"))
//            System.out.println(participant);
//
//        System.out.println("Toti participantii de la o categorie");
//
//        for(Participant participant : participantDbRepository.findByCapacitate(cm3.B))
//            System.out.println(participant);
    }
}
