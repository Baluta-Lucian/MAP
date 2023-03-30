module com.example.lab4mpp {
    requires javafx.controls;
    requires javafx.fxml;

    requires spring.context;
    requires org.apache.logging.log4j;
    requires java.sql;

    opens com.example.lab4mpp to javafx.fxml;
//    opens com.example.lab4mpp to spring.core;

    opens com.example.lab4mpp.repository.file to spring.beans;
    exports com.example.lab4mpp.repository.file;
    opens com.example.lab4mpp.repository.jdbc to spring.beans;
    exports com.example.lab4mpp.repository.jdbc;
    opens com.example.lab4mpp.services to spring.beans;
    exports com.example.lab4mpp.services;
    opens com.example.lab4mpp.controller to javafx.fxml;
    exports com.example.lab4mpp.controller;


    exports com.example.lab4mpp;
}