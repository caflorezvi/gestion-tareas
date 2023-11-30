package negocio.factory;

import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaListaTareas;
import negocio.model.Tarea;

import java.util.List;

public class NotaListaTareasFactory extends NotaFactory {
    private List<Tarea> tareas;

    public NotaListaTareasFactory(String titulo, List<Tarea> tareas, List<Etiqueta> etiquetas) {
        super(titulo, etiquetas);
        this.tareas = tareas;
    }

    @Override
    public Nota crear() {
        return new NotaListaTareas(getCodigo(), getTitulo(), getFechaCreacion(), tareas, getEtiquetas());
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
