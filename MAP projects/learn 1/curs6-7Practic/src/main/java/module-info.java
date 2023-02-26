module com.example.curs67practic {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
   // requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.hotspot.agent;

    opens com.example.curs67practic to javafx.fxml;
    exports com.example.curs67practic;
}