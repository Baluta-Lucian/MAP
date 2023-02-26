module socialnetwork.curs6gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens socialnetwork.curs6gui to javafx.fxml;
    exports socialnetwork.curs6gui;
}