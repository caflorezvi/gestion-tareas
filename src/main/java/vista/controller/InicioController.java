package vista.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import negocio.controller.EtiquetasController;
import negocio.controller.NotasController;
import negocio.model.Etiqueta;
import negocio.model.Tarea;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaBasica;
import negocio.model.notas.NotaListaTareas;
import negocio.model.notas.NotaRecordatorio;
import vista.factory.NotaBasicaVistaFactory;
import vista.factory.NotaListaTareasVistaFactory;
import vista.factory.NotaRecordatorioVistaFactory;
import vista.observer.Observador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InicioController implements Initializable, Observador {

    @FXML
    private HBox columnasNotas;
    private final NotasController notasController = NotasController.getInstancia();
    private EtiquetasController etiquetasController;
    private List<Nota> listaNotas;
    private final int filas = 3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        etiquetasController = new EtiquetasController();

        quemarDatos();
        listaNotas = notasController.listarNotas();

        definirColumnas();
        dibujarNotas();
    }

    public void crearNuevaNota() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/crear.fxml"));
        Parent parent = loader.load();

        CreacionController creacionController = loader.getController();
        creacionController.setObservador(this);

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("App Notas - Crear nota nueva");
        stage.show();

    }

    public void definirColumnas(){

        for(int i= 0; i < filas; i++){
            VBox columnaVBox = new VBox();
            columnasNotas.getChildren().add(columnaVBox);
        }
    }

    public void borrarNotas(){
        for(int i= 0; i < filas; i++){
            ( (VBox) columnasNotas.getChildren().get(i)).getChildren().clear();
        }
    }

    public void dibujarNotas(){
        int columnas = 0;

        for (Nota nota : listaNotas) {
            agregarNotaPanel(nota, columnas);
            columnas++;

            if(columnas == filas)
                columnas = 0;
        }

    }

    public void agregarNotaPanel(Nota nota, int columna){
        VBox notaVBox = (VBox) columnasNotas.getChildren().get(columna);
        if(nota instanceof NotaBasica)
            notaVBox.getChildren().add( new NotaBasicaVistaFactory( (NotaBasica) nota, this) );
        else if(nota instanceof NotaRecordatorio)
            notaVBox.getChildren().add( new NotaRecordatorioVistaFactory( (NotaRecordatorio) nota, this) );
        else
            notaVBox.getChildren().add( new NotaListaTareasVistaFactory( (NotaListaTareas) nota, this) );
    }

    public void quemarDatos(){
        etiquetasController.crearEtiqueta( new Etiqueta("Trabajo", "Azul"));
        etiquetasController.crearEtiqueta( new Etiqueta("Compras", "Verde"));
        etiquetasController.crearEtiqueta( new Etiqueta("Cumpleaños", "Amarillo"));

        List<Etiqueta> etiquetas = etiquetasController.listar();

        notasController.crearNotaBasica("Nota 1", "Contenido de la nota 1", List.of( etiquetas.get(0) ));
        notasController.crearNotaListaTareas("Nota 2", new ArrayList<>( List.of( new Tarea("Estudiar parcial 1"), new Tarea("Enviar trabajo final")) ), List.of( etiquetas.get(0) ));
        notasController.crearNotaConRecordatorio("Nota 3", "Contenido de la nota 3", LocalDateTime.of(2023, 12, 20, 10, 0), List.of( etiquetas.get(1) ));

    }

    @Override
    public void actualizar() {
        listaNotas = notasController.listarNotas();
        borrarNotas();
        dibujarNotas();
    }
}
