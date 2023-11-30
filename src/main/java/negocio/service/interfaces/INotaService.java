package negocio.service.interfaces;

import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.Tarea;

import java.time.LocalDateTime;
import java.util.List;

public interface INotaService{

    String crearNotaBasica(String titulo, String contenido, List<Etiqueta> etiquetas);

    String crearNotaConRecordatorio(String titulo, String contenido, LocalDateTime recordatorio, List<Etiqueta> etiquetas);

    String crearNotaListaTareas(String titulo, List<Tarea> tareas, List<Etiqueta> etiquetas);

    void cambiarEstadoTarea(String codigo, int indiceTarea, boolean estado) throws Exception;

    void eliminarTarea(String codigo, int indiceTarea) throws Exception;

    void eliminarNota(String codigo) throws Exception;

    String actualizarNota(Nota nota) throws Exception;

    List<Nota> listarNotas();

    List<Nota> listarNotasPorEtiqueta(String etiqueta);

    List<Nota> listarNotasPorTituloOContenido(String busqueda);





}
