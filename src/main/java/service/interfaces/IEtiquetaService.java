package service.interfaces;

import dao.ICRUD;
import model.Etiqueta;
import java.util.List;

public interface IEtiquetaService {

    List<Etiqueta> listarEtiquetas();

    void crearEtiqueta(Etiqueta etiqueta);

}
