module com.example.exammap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.exammap to javafx.fxml;
    opens com.example.exammap.domain to javafx.base;
    exports com.example.exammap;
}