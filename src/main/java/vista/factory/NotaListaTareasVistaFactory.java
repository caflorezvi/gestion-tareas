package vista.factory;

import javafx.scene.control.Label;
import negocio.model.notas.NotaListaTareas;
import vista.observer.Observador;

public class NotaListaTareasVistaFactory extends NotaVistaFactory{

    public NotaListaTareasVistaFactory(NotaListaTareas nota, Observador observador) {
        super(nota, observador);
    }

    @Override
    public void dibujar() {
        add(new Label(((NotaListaTareas) getNota()).getTareas().toString()), 0, 3);
    }

}
