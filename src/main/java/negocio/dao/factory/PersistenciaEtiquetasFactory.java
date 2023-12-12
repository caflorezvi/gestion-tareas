package negocio.dao.factory;

import negocio.dao.ICRUD;
import negocio.model.Etiqueta;
import java.util.List;
import java.util.Optional;

public class PersistenciaEtiquetasFactory implements ICRUD<Etiqueta, String> {

    private final ICRUD<Etiqueta, String> etiquetaDAO;

    public PersistenciaEtiquetasFactory(ICRUD<Etiqueta, String> etiquetaDAO) {
        this.etiquetaDAO = etiquetaDAO;
    }

    @Override
    public String crear(Etiqueta etiqueta) {
        return etiquetaDAO.crear(etiqueta);
    }

    @Override
    public List<Etiqueta> listar() {
        return etiquetaDAO.listar();
    }

    @Override
    public String actualizar(Etiqueta etiqueta) throws Exception {
        return etiquetaDAO.actualizar(etiqueta);
    }

    @Override
    public void eliminar(String id) throws Exception {
        etiquetaDAO.eliminar(id);
    }

    @Override
    public Optional<Etiqueta> buscar(String id) {
        return etiquetaDAO.buscar(id);
    }
}
