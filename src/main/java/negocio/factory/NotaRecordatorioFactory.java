package negocio.factory;

import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaRecordatorio;

import java.time.LocalDateTime;
import java.util.List;

public class NotaRecordatorioFactory extends NotaFactory {

    private String contenido;
    private LocalDateTime fechaRecordatorio;

    public NotaRecordatorioFactory(String titulo, String contenido, LocalDateTime fechaRecordatorio, List<Etiqueta> etiquetas) {
        super(titulo, etiquetas);
        this.contenido = contenido;
        this.fechaRecordatorio = fechaRecordatorio;
    }

    @Override
    public Nota crear() {
        return new NotaRecordatorio(getCodigo(), getTitulo(), contenido, getFechaCreacion(), fechaRecordatorio, getEtiquetas());
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
