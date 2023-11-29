package service.impl;

import dao.NotaDAO;
import model.*;
import service.interfaces.INotaService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NotaService implements INotaService {

    private final NotaDAO notaDAO;

    public NotaService() {
        this.notaDAO = new NotaDAO();
    }

    @Override
    public String crearNotaBasica(String titulo, String contenido, List<Etiqueta> etiquetas) {
        String codigo = UUID.randomUUID().toString();
        return this.notaDAO.crear( new NotaBasica(codigo, titulo, LocalDateTime.now(), contenido, etiquetas) );
    }

    @Override
    public String crearNotaConRecordatorio(String titulo, String contenido, LocalDateTime recordatorio, List<Etiqueta> etiquetas) {
        if(recordatorio.isBefore(LocalDateTime.now()))
            throw new RuntimeException("La fecha de recordatorio no puede ser anterior a la fecha actual");

        String codigo = UUID.randomUUID().toString();
        return this.notaDAO.crear( new NotaRecordatorio(codigo, titulo, contenido, LocalDateTime.now(), recordatorio, etiquetas) );
    }

    @Override
    public String crearNotaListaTareas(String titulo, List<Tarea> tareas, List<Etiqueta> etiquetas) {
        String codigo = UUID.randomUUID().toString();
        return this.notaDAO.crear( new NotaListaTareas(codigo, titulo, LocalDateTime.now(), tareas, etiquetas) );
    }

    @Override
    public void cambiarEstadoTarea(String codigo, int indiceTarea, boolean estado) throws Exception {
        Optional<Nota> notaOptional = this.notaDAO.buscar(codigo);

        if(notaOptional.isPresent()) {
            Nota nota = notaOptional.get();
            if(nota instanceof NotaListaTareas notaListaTareas) {
                List<Tarea> tareas = notaListaTareas.getTareas();
                tareas.get(indiceTarea).setCompletada(estado);
                notaListaTareas.setTareas(tareas);
                this.notaDAO.actualizar(notaListaTareas);
            }
        }
    }

    @Override
    public void eliminarTarea(String codigo, int indiceTarea) throws Exception {
        Optional<Nota> notaOptional = this.notaDAO.buscar(codigo);

        if(notaOptional.isPresent()){
            Nota nota = notaOptional.get();
            if(nota instanceof NotaListaTareas notaListaTareas) {
                List<Tarea> tareas = notaListaTareas.getTareas();
                tareas.remove(indiceTarea);
                notaListaTareas.setTareas(tareas);
                this.notaDAO.actualizar(notaListaTareas);
            }
        }
    }

    @Override
    public void eliminarNota(String codigo) throws Exception {
        this.notaDAO.eliminar(codigo);
    }

    @Override
    public String actualizarNota(Nota nota) throws Exception {
        return this.notaDAO.actualizar(nota);
    }

    @Override
    public List<Nota> listarNotas() {
        return this.notaDAO.listar();
    }

    @Override
    public List<Nota> listarNotasPorEtiqueta(String etiqueta) {
        return this.notaDAO.listarNotasPorEtiqueta(etiqueta);
    }

    @Override
    public List<Nota> listarNotasPorTituloOContenido(String busqueda) {
        return this.notaDAO.listarNotasPorTitulo(busqueda);
    }
}
