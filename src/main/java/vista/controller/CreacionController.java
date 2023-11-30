package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import negocio.controller.NotasController;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaBasica;
import negocio.model.notas.NotaRecordatorio;
import vista.observer.Observador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreacionController implements Initializable {

    @FXML
    private TextField titulo;

    @FXML
    private TextField contenido;
    private Observador observador;
    private Nota nota;
    private boolean esEdicion;
    private final NotasController notasController = NotasController.getInstancia();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        esEdicion = false;
    }

    public void crearNota() throws Exception{

        if(esEdicion) {
            editarNota();
        } else {
            crearNuevaNota();
        }
    }

    public void crearNuevaNota() {

        String tituloTexto = titulo.getText();
        String contenidoTexto = contenido.getText();

        notasController.crearNotaBasica(tituloTexto, contenidoTexto, new ArrayList<>());
        observador.actualizar();

        mostrarAlerta("Nota creada correctamente");
    }

    public void editarNota() throws Exception {

        String tituloTexto = titulo.getText();
        String contenidoTexto = contenido.getText();

        nota.setTitulo(tituloTexto);

        if( nota instanceof NotaRecordatorio)
            ((NotaRecordatorio) nota).setContenido(contenidoTexto);
        else if( nota instanceof NotaBasica)
            ((NotaBasica) nota).setContenido(contenidoTexto);

        notasController.actualizarNota(nota);
        observador.actualizar();

        mostrarAlerta("Nota editada correctamente");
    }

    public void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("App Notas");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }

    public void setNota(Nota nota) {
        this.nota = nota;

        esEdicion = true;
        titulo.setText(nota.getTitulo());

        if( nota instanceof NotaRecordatorio)
            contenido.setText(((NotaRecordatorio) nota).getContenido());
        else if( nota instanceof NotaBasica)
            contenido.setText(((NotaBasica) nota).getContenido());

    }

}
