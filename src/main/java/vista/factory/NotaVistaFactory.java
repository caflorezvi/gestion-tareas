package vista.factory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import negocio.model.notas.Nota;
import vista.controller.CreacionController;
import vista.observer.Observador;
import java.io.IOException;

public abstract class NotaVistaFactory extends GridPane implements INotaVistaFactory {

    private Nota nota;
    private Observador observador;

    public NotaVistaFactory(Nota nota, Observador observador){

        this.nota = nota;
        this.observador = observador;
        agregarBase();
        dibujar();

        setOnMouseClicked(mouseEvent -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/crear.fxml"));
                Parent parent = loader.load();

                CreacionController creacionController = loader.getController();
                creacionController.setObservador(observador);
                creacionController.setNota(nota);

                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("App Notas - "+nota.getTitulo());
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

    }

    public void agregarBase(){

        setBackground( new Background( new BackgroundFill(Color.rgb(255,255,153), null, null)));
        add( new Label(getNota().getTitulo()), 0, 0);
        add( new Label(getNota().getFechaCreacion().toString()), 0, 1);
        add( new Label(getNota().getEtiquetas().toString()), 0, 2);
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Observador getObservador() {
        return observador;
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }
}
