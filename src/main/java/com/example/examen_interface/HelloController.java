package com.example.examen_interface;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private ToggleGroup rbTarifa;
    @FXML
    private TableColumn<Coche, String> colMatricula;
    @FXML
    private TableColumn<Coche, String> colModelo;
    @FXML
    private TableColumn<Coche, String> colFechaEntrada;
    @FXML
    private TableColumn<Coche, String> colFechaSalida;
    @FXML
    private TableColumn<Coche, String> colCliente;
    @FXML
    private TableColumn<Coche, String> colTarifa;
    @FXML
    private TableColumn<Coche, String> colCoste;
    @FXML
    private Label lblFooter;
    @FXML
    private Label lblHeader;
    @FXML
    private ComboBox<String> comboModelo;
    @FXML
    private ComboBox<String> comboCliente;
    @FXML
    private TableView<Coche> tabla;
    private ObservableList<Coche> entrada = FXCollections.observableArrayList();


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



        colMatricula.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getMatricula())
        );

        colModelo.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getModelo())
        );

        colFechaEntrada.setCellValueFactory((fila)->
                new SimpleStringProperty(
                        fila.getValue().getEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                )
        );


        colFechaSalida.setCellValueFactory((fila)->
                new SimpleStringProperty(
                        fila.getValue().getSalida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                )
        );



        colCliente.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getCliente())
        );

        colTarifa.setCellValueFactory((fila) ->
                new SimpleStringProperty(fila.getValue().getTarifa())
        );

        colCoste.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getCoste()+"")
        );



        tabla.setItems(entrada);

    }





    @FXML
    public void add(ActionEvent actionEvent) {
        if (!txtMatricula.getText().isEmpty() && comboModelo.getValue() != null
                && comboCliente.getValue() != null && dpEntrada.getValue() != null
                && dpSalida.getValue() != null && !txtCoste.getText().isEmpty()) {

            String matricula = txtMatricula.getText();
            String modelo = comboModelo.getValue().toString();
            String cliente = comboCliente.getValue().toString();
            LocalDate fechaEntrada = dpEntrada.getValue();
            LocalDate fechaSalida = dpSalida.getValue();

            String tar = "";
            ToggleGroup toggleGroup = rbTarifa;
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

            if (selectedRadioButton != null) {
                tar = selectedRadioButton.getText();
            }

            int coste = Integer.parseInt(txtCoste.getText());


            Coche nuevoCoche = new Coche(matricula, modelo, cliente, tar, fechaEntrada, fechaSalida, coste);
            entrada.add(nuevoCoche);

            limpiarCampos();
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