package negocio.model.notas;

import negocio.model.Etiqueta;

import java.time.LocalDateTime;
import java.util.List;

public class NotaBasica extends Nota{

    private String contenido;

    public NotaBasica(String codigo, String titulo, LocalDateTime fechaCreacion, String contenido, List<Etiqueta> etiquetas) {
        super(codigo, titulo, fechaCreacion, etiquetas);
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public static NotaBasicaBuilder builder() {
        return new NotaBasicaBuilder();
    }

    @Override
    public String toString() {
        return "NotaBasica{" +
                "texto='" + contenido + '\'' +
                "} " + super.toString();
    }
}
