package com.example.lab4mpp;

import com.example.lab4mpp.controller.ComputerRepairShopController;
import com.example.lab4mpp.services.ComputerRepairServices;
import com.example.lab4mpp.services.ServicesException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFXSpring extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RepairShopWindow.fxml"));
            Parent root = loader.load();
            ComputerRepairShopController ctrl = loader.getController();
            ctrl.setService(getService());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Computer Repairs Shop");
            primaryStage.show();
        }catch(Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("Error while starting app "+e);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    static ComputerRepairServices getService() throws ServicesException {
        // pentru configurare folosind XML
        ApplicationContext context=new ClassPathXmlApplicationContext("RepairShopConfig.fxml");

        //pentru configurare folosind JavaConfig
//        System.out.println(RepairShopConfig.class);
//        ApplicationContext context=new AnnotationConfigApplicationContext(RepairShopConfig.class);

        ComputerRepairServices services=context.getBean(ComputerRepairServices.class);
        return services;

    }
}

