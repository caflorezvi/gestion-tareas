package negocio.service.interfaces;

import negocio.model.Etiqueta;

import java.util.List;

public interface IEtiquetaService {

    List<Etiqueta> listarEtiquetas();

    void crearEtiqueta(Etiqueta etiqueta);

}
