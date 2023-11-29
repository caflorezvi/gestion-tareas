package controller;

import model.Etiqueta;
import service.interfaces.IEtiquetaService;
import service.impl.EtiquetaService;
import java.util.List;

public class EtiquetasController {

    private final IEtiquetaService etiquetaService;

    public EtiquetasController() {
        this.etiquetaService = new EtiquetaService();
    }

    public void crearEtiqueta(Etiqueta etiqueta) {
        this.etiquetaService.crearEtiqueta(etiqueta);
    }

    public List<Etiqueta> listar() {
        return this.etiquetaService.listarEtiquetas();
    }

}
