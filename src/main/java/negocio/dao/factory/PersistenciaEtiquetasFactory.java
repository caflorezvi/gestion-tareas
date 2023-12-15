package negocio.dao.factory;

import negocio.dao.ICRUD;
import negocio.dao.notas.EtiquetasRepository;
import negocio.model.Etiqueta;
import java.util.List;
import java.util.Optional;

public class PersistenciaEtiquetasFactory {

    private final EtiquetasRepository etiquetaDAO;

    public PersistenciaEtiquetasFactory(EtiquetasRepository etiquetaDAO) {
        this.etiquetaDAO = etiquetaDAO;
    }

    public String crear(Etiqueta etiqueta) {
        return etiquetaDAO.crear(etiqueta);
    }

    public List<Etiqueta> listar() {
        return etiquetaDAO.listar();
    }

    public String actualizar(Etiqueta etiqueta) throws Exception {
        return etiquetaDAO.actualizar(etiqueta);
    }

    public void eliminar(String id) throws Exception {
        etiquetaDAO.eliminar(id);
    }

    public Optional<Etiqueta> buscar(String id) {
        return etiquetaDAO.buscar(id);
    }
}
