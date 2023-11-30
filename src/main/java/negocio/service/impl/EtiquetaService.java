package negocio.service.impl;

import negocio.dao.EtiquetaDAO;
import negocio.model.Etiqueta;
import negocio.service.interfaces.IEtiquetaService;

import java.util.List;
import java.util.Optional;

public class EtiquetaService implements IEtiquetaService {

    private final EtiquetaDAO etiquetaDAO;

    public EtiquetaService() {
        this.etiquetaDAO = new EtiquetaDAO();
    }

    @Override
    public List<Etiqueta> listarEtiquetas() {
        return etiquetaDAO.listar();
    }

    @Override
    public void crearEtiqueta(Etiqueta etiqueta) {

        Optional<Etiqueta> etiquetaOptional = etiquetaDAO.buscar(etiqueta.getNombre());

        if(etiquetaOptional.isPresent())
            throw new RuntimeException("Ya existe una etiqueta con ese nombre");

        etiquetaDAO.crear(etiqueta);
    }
}
