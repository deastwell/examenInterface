package com.example.examen_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txtMatricula;
    @FXML
    private RadioButton rbStandard;
    @FXML
    private RadioButton rbOferta;
    @FXML
    private RadioButton rbLargaDuracion;
    @FXML
    private TextField txtCoste;
    @FXML
    private DatePicker dpEntrada;
    @FXML
    private DatePicker dpSalida;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnSalir;
    @FXML
    private TableColumn colMatricula;
    @FXML
    private TableColumn colModelo;
    @FXML
    private TableColumn colFechaEntrada;
    @FXML
    private TableColumn colFechaSalida;
    @FXML
    private TableColumn colCliente;
    @FXML
    private TableColumn colTarifa;
    @FXML
    private TableColumn colCoste;
    @FXML
    private Label lblFooter;
    @FXML
    private Label lblHeader;
    @FXML
    private ComboBox comboModelo;
    @FXML
    private ComboBox comboCliente;
    @FXML
    private TableView tabla;


    @FXML
    protected void onHelloButtonClick() {





    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblFooter.setOnMouseClicked(event -> mostrarAlerta("HECHO POR DANIEL EASTWELL"));

        comboModelo.getItems().add("Ferrari");
        comboModelo.getItems().add("Tesla");
        comboModelo.getItems().add("McLaren");
        comboModelo.getSelectionModel().selectFirst();

        comboCliente.getItems().add("Pepe");
        comboCliente.getItems().add("Juan");
        comboCliente.getItems().add("Pepito");
        comboCliente.getSelectionModel().selectFirst();



    }

    @Deprecated
    public void add(ActionEvent actionEvent) {
        if (!txtMatricula.getText().isEmpty() && comboModelo.getValue() != null
                && comboCliente.getValue() != null && dpEntrada.getValue() != null
                && dpSalida.getValue() != null && !txtCoste.getText().isEmpty()) {

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Campos obligatorios");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, completa todos los campos");
            alert.showAndWait();
        }
    }
    private void limpiarCampos() {
        txtMatricula.clear();
        comboModelo.getSelectionModel().clearSelection();
        comboCliente.getSelectionModel().clearSelection();
        dpEntrada.setValue(null);
        dpSalida.setValue(null);
        txtCoste.clear();
    }




    @FXML
    public void Salir(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void insertarReceta(ActionEvent actionEvent) {
    }

    private void mostrarAlerta(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}