package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Nota {

    private String codigo;
    private String titulo;
    private LocalDateTime fechaCreacion;
    private List<Etiqueta> etiquetas;

    public Nota(String codigo, String titulo, LocalDateTime fechaCreacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
    }

    public Nota(String codigo, String titulo, LocalDateTime fechaCreacion, List<Etiqueta> etiquetas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.etiquetas = etiquetas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    @Override
    public String toString() {
        return "Nota{" + "codigo=" + codigo + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", etiquetas=" + etiquetas + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nota nota = (Nota) o;

        return Objects.equals(codigo, nota.codigo);
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
