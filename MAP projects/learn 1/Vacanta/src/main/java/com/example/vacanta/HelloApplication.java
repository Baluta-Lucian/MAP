package com.example.vacanta;

import com.example.vacanta.domain.Hotel;
import com.example.vacanta.domain.Locatie;
import com.example.vacanta.repository.Repository;
import com.example.vacanta.repository.db.RepositoryDbHoteluri;
import com.example.vacanta.repository.db.RepositoryDbLocatii;
import com.example.vacanta.service.Service;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    //database url
//jdbc:postgresql://localhost:5432/ProjectHotel
    public static void main(String[] args) {


//        this was test for DB
//        String url = "jdbc:postgresql://localhost:5432/ProjectHotel";
//        String username = "postgres";
//        String password = "CripiFace2";
//        Repository<Double, Hotel> hotelRepository = new RepositoryDbHoteluri(url, username, password);
//        Repository<Double, Locatie> locatieRepository = new RepositoryDbLocatii(url, username, password);
//        Service service = new Service((RepositoryDbLocatii) locatieRepository, (RepositoryDbHoteluri) hotelRepository);
//        Locatie locatie = service.getLocations().get(0);
//        service.searchHotelsInLocation(locatie).forEach(System.out::println);
//        hotelRepository.findAll().forEach(System.out::println);
        launch();
    }
}