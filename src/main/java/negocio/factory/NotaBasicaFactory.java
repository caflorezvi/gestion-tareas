package negocio.factory;

import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaBasica;

import java.util.List;

public class NotaBasicaFactory extends NotaFactory {

    private String contenido;

    public NotaBasicaFactory(String titulo, String contenido, List<Etiqueta> etiquetas) {
        super(titulo, etiquetas);
        this.contenido = contenido;
    }

    @Override
    public Nota crear() {
        return NotaBasica.builder()
                .codigo(getCodigo())
                .fechaCreacion(getFechaCreacion())
                .titulo(getTitulo())
                .etiquetas(getEtiquetas())
                .contenido(contenido).build();
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
