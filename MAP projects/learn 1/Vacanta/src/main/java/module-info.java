module com.example.vacanta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vacanta to javafx.fxml;
    opens com.example.vacanta.domain to javafx.base;
    exports com.example.vacanta;
}