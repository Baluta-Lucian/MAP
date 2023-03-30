module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;


    opens org.example to javafx.fxml;
//    opens org.example.utils.events to javafx.fxml;
//    opens org.example.utils.observer to javafx.fxml;
    opens org.example.domain to javafx.fxml;
//    opens org.example.views to javafx.fxml;
    opens org.example.controller to javafx.fxml;
    opens org.example.service to javafx.fxml;
    opens org.example.repository to javafx.fxml;


    exports org.example;
    exports org.example.controller;
//    exports org.example.views;
//    exports org.example.utils.events;
//    exports org.example.utils.observer;
    exports org.example.service;
    exports org.example.domain;
    exports org.example.repository;

}