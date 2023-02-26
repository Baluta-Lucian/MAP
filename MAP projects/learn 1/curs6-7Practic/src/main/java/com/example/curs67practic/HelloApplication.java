package com.example.curs67practic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;

import java.io.IOException;

//import static com.sun.java.swing.ui.CommonUI.createLabel;


public class HelloApplication extends Application {
    private Node initTop(){
        AnchorPane anchorPane = new AnchorPane();

        Label l = new Label("Student managemenet system");
        l.setFont(new Font(20));

        AnchorPane.setTopAnchor(l, 20d);
        AnchorPane.setRightAnchor(l, 100d);
        anchorPane.getChildren().add(l);

        Image img = new Image("Logo.jpg");
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        AnchorPane.setLeftAnchor(imageView, 20d);
        AnchorPane.setRightAnchor(imageView, 10d);
        anchorPane.getChildren().add(imageView);

        return anchorPane;
            }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        HBox root = new HBox(5);
//        root.setPadding(new Insets(100));
//        root.setAlignment(Pos.BASELINE_RIGHT);

//        Button prevBtn = new Button("Previous");
//        Button nextBtn = new Button("Next");
//        Button cancBtn = new Button("Cancel");
//        Button helpBtn = new Button("Help");
//        root.getChildren().addAll(prevBtn, nextBtn, cancBtn, helpBtn);
//



//        VBox root = new VBox(5);
//        root.setPadding(new Insets(20));
//        root.setAlignment(Pos.BASELINE_LEFT);
//
//        Button prevBtn = new Button("Previous");
//        Button nextBtn = new Button("Next");
//        Button cancBtn = new Button("Cancel");
//        Button helpBtn = new Button("Help");
//
//        root.getChildren().addAll(prevBtn, nextBtn, cancBtn, helpBtn);
//
//
//        AnchorPane root = new AnchorPane();
//
//        Button okBtn = new Button("Ok");
//        Button cancBtn = new Button("Cancel");
//        HBox hbox = new HBox(5, okBtn, cancBtn);
//
//        root.getChildren().addAll(hbox);
//
//        AnchorPane.setRightAnchor(hbox,10d);
//        AnchorPane.setBottomAnchor(hbox, 10d);

       // AnchorPane root = (AnchorPane) initTop();
                //-> astea doua nefunctionale
        //root.getChildren().addAll(this.initTop());



        /*
        * Model username - parola
        *
        * MUST TRY
        *
        * */
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        root.add(new Label("Username: "), 0, 0);
        root.add(new Label("Password: "), 0, 1);

        root.add(new TextField(),1 ,0);
        root.add(new PasswordField(),1,1);


        Scene scene = new Scene(root, 550, 500, Color.PINK);

//        //Cream un grup nou
//       Group group = new Group();
//
//        //Cream un nod de tip Rectangle
//
//        Rectangle r = new Rectangle(25, 25, 50, 50);
//        r.setFill(Color.BLUE);
//        group.getChildren().add(r);
//
//        //Cream un nod de tip Circle
//
//        Circle c = new Circle(200, 200, 50, Color.web("blue", 0.5f));
//        group.getChildren().add(c);
//
//        root.getChildren().add(group);

        stage.setTitle("Welcome to JavaFX!!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}