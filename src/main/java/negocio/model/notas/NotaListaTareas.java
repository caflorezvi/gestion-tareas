package negocio.model.notas;

import lombok.Builder;
import negocio.model.Etiqueta;
import negocio.model.Tarea;
import java.time.LocalDateTime;
import java.util.List;

public class NotaListaTareas extends Nota{

    private List<Tarea> tareas;

    @Builder
    public NotaListaTareas(String codigo, String titulo, LocalDateTime fechaCreacion, List<Tarea> tareas, List<Etiqueta> etiquetas) {
        super(codigo, titulo, fechaCreacion, etiquetas);
        this.tareas = tareas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return "NotaListaTareas{" +
                "tareas=" + tareas +
                "} " + super.toString();
    }
}
