module com.example.examen_interface {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.examen_interface to javafx.fxml;
    exports com.example.examen_interface;
}