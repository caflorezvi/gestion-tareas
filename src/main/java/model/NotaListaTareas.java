package model;

import java.time.LocalDateTime;
import java.util.List;

public class NotaListaTareas extends Nota{

    private List<Tarea> tareas;

    public NotaListaTareas(String codigo, String titulo, LocalDateTime fechaCreacion, List<Tarea> tareas) {
        super(codigo, titulo, fechaCreacion);
        this.tareas = tareas;
    }

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