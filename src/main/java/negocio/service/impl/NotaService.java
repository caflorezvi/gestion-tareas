package negocio.service.impl;

import negocio.dao.factory.PersistenciaNotasFactory;
import negocio.dao.memoria.NotaMemoriaDAO;
import negocio.factory.INotaFactory;
import negocio.factory.NotaBasicaFactory;
import negocio.factory.NotaListaTareasFactory;
import negocio.factory.NotaRecordatorioFactory;
import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.notas.NotaListaTareas;
import negocio.model.Tarea;
import negocio.service.interfaces.INotaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class NotaService implements INotaService {

    private final PersistenciaNotasFactory notaDAO;

    public NotaService() {
        this.notaDAO = new PersistenciaNotasFactory(new NotaMemoriaDAO());
    }

    @Override
    public String crearNotaBasica(String titulo, String contenido, List<Etiqueta> etiquetas) {
        NotaBasicaFactory notaBasicaFactory = new NotaBasicaFactory(titulo, contenido, etiquetas);
        return crearNota(notaBasicaFactory);
    }

    @Override
    public String crearNotaConRecordatorio(String titulo, String contenido, LocalDateTime recordatorio, List<Etiqueta> etiquetas) {
        if(recordatorio.isBefore(LocalDateTime.now()))
            throw new RuntimeException("La fecha de recordatorio no puede ser anterior a la fecha actual");

        NotaRecordatorioFactory notaRecordatorioFactory = new NotaRecordatorioFactory(titulo, contenido, recordatorio, etiquetas);
        return crearNota(notaRecordatorioFactory);
    }

    @Override
    public String crearNotaListaTareas(String titulo, List<Tarea> tareas, List<Etiqueta> etiquetas) {
        NotaListaTareasFactory notaListaTareasFactory = new NotaListaTareasFactory(titulo, tareas, etiquetas);
        return crearNota(notaListaTareasFactory);
    }

    private String crearNota(INotaFactory notaFactory) {
        Nota notaNueva = notaFactory.crear();
        this.notaDAO.crear(notaNueva);
        return notaNueva.getCodigo();
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
        return this.listarNotas().stream().filter( nota -> nota.getEtiquetas().stream().anyMatch(e -> e.getNombre().toLowerCase().contains(etiqueta.toLowerCase())) ).toList();
    }

    @Override
    public List<Nota> listarNotasPorTituloOContenido(String busqueda) {
        return this.listarNotas().stream().filter( nota -> nota.getTitulo().toLowerCase().contains(busqueda.toLowerCase()) ).toList();
    }
}
