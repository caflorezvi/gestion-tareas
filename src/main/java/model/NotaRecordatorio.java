package model;

import java.time.LocalDateTime;
import java.util.List;

public class NotaRecordatorio extends Nota {

    private String texto;
    private LocalDateTime fechaRecordatorio;

    public NotaRecordatorio(String codigo, String titulo, String texto, LocalDateTime fechaCreacion, LocalDateTime fechaRecordatorio) {
        super(codigo, titulo, fechaCreacion);
        this.texto = texto;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public NotaRecordatorio(String codigo, String titulo, String texto, LocalDateTime fechaCreacion, LocalDateTime fechaRecordatorio, List<Etiqueta> etiquetas) {
        super(codigo, titulo, fechaCreacion, etiquetas);
        this.texto = texto;
        this.fechaRecordatorio = fechaRecordatorio;
    }

}
