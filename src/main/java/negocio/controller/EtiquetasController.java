package negocio.controller;

import negocio.model.Etiqueta;
import negocio.service.impl.EtiquetaService;
import negocio.service.interfaces.IEtiquetaService;

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
