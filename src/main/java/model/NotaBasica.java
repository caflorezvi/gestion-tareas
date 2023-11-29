package model;

import java.time.LocalDateTime;
import java.util.List;

public class NotaBasica extends Nota{

    private String texto;

    public NotaBasica(String codigo, String titulo, LocalDateTime fechaCreacion, String texto) {
        super(codigo, titulo, fechaCreacion);
        this.texto = texto;
    }

    public NotaBasica(String codigo, String titulo, LocalDateTime fechaCreacion, String texto, List<Etiqueta> etiquetas) {
        super(codigo, titulo, fechaCreacion, etiquetas);
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "NotaBasica{" +
                "texto='" + texto + '\'' +
                "} " + super.toString();
    }
}
