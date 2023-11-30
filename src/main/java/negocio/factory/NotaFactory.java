package negocio.factory;

import negocio.model.Etiqueta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public abstract class NotaFactory implements INotaFactory {

    private String codigo, titulo;
    private LocalDateTime fechaCreacion;
    private List<Etiqueta> etiquetas;

    public NotaFactory(String titulo, List<Etiqueta> etiquetas) {
        this.codigo = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.fechaCreacion = LocalDateTime.now();
        this.etiquetas = etiquetas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
