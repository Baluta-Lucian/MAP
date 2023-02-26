package com.example.genericexam.controller;

import com.example.genericexam.Main;
import com.example.genericexam.service.Service;
import com.example.genericexam.service.ServiceProfesor;
import com.example.genericexam.service.ServiceStudent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    ServiceStudent serviceStudent;
    ServiceProfesor serviceProfesor;

    String s1;
    String s2;
    String s3;

    int i = 1;

    @FXML
    private Button myStartBtn;

    public void setService(ServiceStudent serviceStudent, ServiceProfesor serviceProfesor){
        this.serviceStudent = serviceStudent;
        this.serviceProfesor = serviceProfesor;
    }

    public void passArgs(String s1, String s2, String s3){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @FXML
    void onButtonPush(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoaderS1 = new FXMLLoader(Main.class.getResource("student-view.fxml"));
        Scene scene1 = new Scene(fxmlLoaderS1.load(), 500, 500);
        Stage stage1 = new Stage();
        StudentController studentController1 = fxmlLoaderS1.getController();
        studentController1.setService(this.serviceStudent, this.serviceProfesor);
        studentController1.setStudent(this.s1);

        stage1.setTitle(this.s1);
        stage1.setScene(scene1);
        stage1.show();

        FXMLLoader fxmlLoaderS2 = new FXMLLoader(Main.class.getResource("student-view.fxml"));
        Scene scene2 = new Scene(fxmlLoaderS2.load(), 500, 500);
        Stage stage2 = new Stage();
        StudentController studentController2 = fxmlLoaderS2.getController();
        studentController2.setService(this.serviceStudent, this.serviceProfesor);
        studentController2.setStudent(this.s2);

        stage2.setTitle(this.s2);
        stage2.setScene(scene2);
        stage2.show();

        FXMLLoader fxmlLoaderS3 = new FXMLLoader(Main.class.getResource("student-view.fxml"));
        Scene scene3 = new Scene(fxmlLoaderS3.load(), 500, 500);
        Stage stage3 = new Stage();
        StudentController studentController3 = fxmlLoaderS3.getController();
        studentController3.setService(this.serviceStudent, this.serviceProfesor);
        studentController3.setStudent(this.s3);
        
        stage3.setTitle(this.s3);
        stage3.setScene(scene3);
        stage3.show();

        FXMLLoader fxmlLoaderP = new FXMLLoader(Main.class.getResource("profesor-view.fxml"));
        Scene sceneP = new Scene(fxmlLoaderP.load(), 500, 500);
        Stage stageP = new Stage();
        ProfesorController profesorController = fxmlLoaderP.getController();
        profesorController.setService(this.serviceStudent, this.serviceProfesor);

        stageP.setTitle("Evaluator");
        stageP.setScene(sceneP);
        stageP.show();


    }



}
