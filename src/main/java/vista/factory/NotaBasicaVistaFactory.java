package vista.factory;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import negocio.model.notas.NotaBasica;
import vista.observer.Observador;

public class NotaBasicaVistaFactory extends NotaVistaFactory{

    public NotaBasicaVistaFactory(NotaBasica nota, Observador observador) {
        super(nota, observador);
    }

    @Override
    public void dibujar() {
        add( new Label(((NotaBasica) getNota()).getContenido()), 0, 3);
    }
}
