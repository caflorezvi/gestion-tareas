package negocio.model.notas;

import negocio.model.Etiqueta;
import java.time.LocalDateTime;
import java.util.List;

public class NotaBasicaBuilder {

    private String codigo;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private List<Etiqueta> etiquetas;

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public NotaBasicaBuilder codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public NotaBasicaBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public NotaBasicaBuilder contenido(String contenido) {
        this.contenido = contenido;
        return this;
    }

    public NotaBasicaBuilder fechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public NotaBasicaBuilder etiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
        return this;
    }

    public NotaBasica build() {
        return new NotaBasica(codigo, titulo, fechaCreacion, contenido, etiquetas);
    }

}
