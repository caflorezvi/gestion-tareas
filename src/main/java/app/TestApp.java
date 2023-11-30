package app;

import negocio.controller.EtiquetasController;
import negocio.controller.NotasController;
import negocio.model.Etiqueta;
import negocio.model.notas.Nota;
import negocio.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws Exception {

        NotasController notasController = NotasController.getInstancia();
        EtiquetasController etiquetasController = new EtiquetasController();

        etiquetasController.crearEtiqueta( new Etiqueta("Trabajo", "Azul"));
        etiquetasController.crearEtiqueta( new Etiqueta("Compras", "Verde"));
        etiquetasController.crearEtiqueta( new Etiqueta("Cumpleaños", "Amarillo"));

        List<Etiqueta> etiquetas = etiquetasController.listar();

        notasController.crearNotaBasica("Nota 1", "Contenido de la nota 1", List.of( etiquetas.get(0) ));
        notasController.crearNotaListaTareas("Nota 2", new ArrayList<>( List.of( new Tarea("Estudiar parcial 1"), new Tarea("Enviar trabajo final")) ), List.of( etiquetas.get(0) ));

        List<Nota> notas = notasController.listarNotas();
        System.out.println(notas);

        notasController.eliminarTarea(notas.get(1).getCodigo(), 0);

        notas = notasController.listarNotas();

        System.out.println(notas);

    }

}
