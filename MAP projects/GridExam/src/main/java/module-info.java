module com.example.genericexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.genericexam to javafx.fxml;
    opens com.example.genericexam.utils.events to javafx.fxml;
    opens com.example.genericexam.utils.observer to javafx.fxml;
    opens com.example.genericexam.domain to javafx.fxml;
    opens com.example.genericexam.controller to javafx.fxml;
    opens com.example.genericexam.service to javafx.fxml;
    opens com.example.genericexam.repository to javafx.fxml;


    exports com.example.genericexam;
    exports com.example.genericexam.controller;
    exports com.example.genericexam.utils.events;
    exports com.example.genericexam.utils.observer;
    exports com.example.genericexam.service;
    exports com.example.genericexam.domain;
    exports com.example.genericexam.repository;

}