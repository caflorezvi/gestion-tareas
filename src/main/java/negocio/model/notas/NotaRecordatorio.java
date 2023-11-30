package negocio.model.notas;

import negocio.model.Etiqueta;
import java.time.LocalDateTime;
import java.util.List;

public class NotaRecordatorio extends Nota {

    private String contenido;
    private LocalDateTime fechaRecordatorio;

    public NotaRecordatorio(String codigo, String titulo, String contenido, LocalDateTime fechaCreacion, LocalDateTime fechaRecordatorio) {
        super(codigo, titulo, fechaCreacion);
        this.contenido = contenido;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public NotaRecordatorio(String codigo, String titulo, String contenido, LocalDateTime fechaCreacion, LocalDateTime fechaRecordatorio, List<Etiqueta> etiquetas) {
        super(codigo, titulo, fechaCreacion, etiquetas);
        this.contenido = contenido;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(LocalDateTime fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }
}
