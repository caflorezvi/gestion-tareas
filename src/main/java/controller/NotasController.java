package controller;

import model.Etiqueta;
import model.Nota;
import model.Tarea;
import service.interfaces.INotaService;
import service.impl.NotaService;

import java.time.LocalDateTime;
import java.util.List;

public class NotasController implements INotaService {

    private final INotaService notaService;

    public NotasController() {
        this.notaService = new NotaService();
    }

    @Override
    public String crearNotaBasica(String titulo, String contenido, List<Etiqueta> etiquetas) {
        return notaService.crearNotaBasica(titulo, contenido, etiquetas);
    }

    @Override
    public String crearNotaConRecordatorio(String titulo, String contenido, LocalDateTime recordatorio, List<Etiqueta> etiquetas) {
        return notaService.crearNotaConRecordatorio(titulo, contenido, recordatorio, etiquetas);
    }

    @Override
    public String crearNotaListaTareas(String titulo, List<Tarea> tareas, List<Etiqueta> etiquetas) {
        return notaService.crearNotaListaTareas(titulo, tareas, etiquetas);
    }

    @Override
    public void cambiarEstadoTarea(String codigo, int indiceTarea, boolean estado) throws Exception {
        this.notaService.cambiarEstadoTarea(codigo, indiceTarea, estado);
    }

    @Override
    public void eliminarTarea(String codigo, int indiceTarea) throws Exception {
        this.notaService.eliminarTarea(codigo, indiceTarea);
    }

    @Override
    public void eliminarNota(String codigo) throws Exception {
        notaService.eliminarNota(codigo);
    }

    @Override
    public String actualizarNota(Nota nota) throws Exception {
        return notaService.actualizarNota(nota);
    }

    @Override
    public List<Nota> listarNotas() {
        return notaService.listarNotas();
    }

    @Override
    public List<Nota> listarNotasPorEtiqueta(String etiqueta) {
        return notaService.listarNotasPorEtiqueta(etiqueta);
    }

    @Override
    public List<Nota> listarNotasPorTituloOContenido(String busqueda) {
        return notaService.listarNotasPorTituloOContenido(busqueda);
    }
}
