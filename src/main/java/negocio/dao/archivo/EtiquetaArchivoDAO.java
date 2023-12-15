package negocio.dao.archivo;

import negocio.dao.repositorios.EtiquetasRepository;
import negocio.model.Etiqueta;
import java.util.List;
import java.util.Optional;

public class EtiquetaArchivoDAO implements EtiquetasRepository {

    @Override
    public String crear(Etiqueta etiqueta) {
        return null;
    }

    @Override
    public List<Etiqueta> listar() {
        return null;
    }

    @Override
    public String actualizar(Etiqueta etiqueta) throws Exception {
        return null;
    }

    @Override
    public void eliminar(String id) throws Exception {

    }

    @Override
    public Optional<Etiqueta> buscar(String id) {
        return Optional.empty();
    }
}
