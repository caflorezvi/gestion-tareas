package vista.factory;

import javafx.scene.control.Label;
import negocio.model.notas.NotaRecordatorio;
import vista.observer.Observador;

public class NotaRecordatorioVistaFactory extends NotaVistaFactory{

    public NotaRecordatorioVistaFactory(NotaRecordatorio notaRecordatorio, Observador observador){
        super(notaRecordatorio, observador);
    }

    @Override
    public void dibujar() {
        add(new Label(((NotaRecordatorio) getNota()).getContenido()), 0, 3);
        add(new Label(((NotaRecordatorio) getNota()).getFechaRecordatorio().toString()), 0, 4);
    }

}
