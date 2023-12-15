package negocio.dao.factory;

import negocio.dao.notas.NotasRepository;
import negocio.model.notas.Nota;
import java.util.List;
import java.util.Optional;

public class PersistenciaNotasFactory {

    private final NotasRepository notaDAO;

    public PersistenciaNotasFactory(NotasRepository notaDAO ) {
        this.notaDAO = notaDAO;
    }

    public String crear(Nota nota) {
        return notaDAO.crear(nota);
    }

    public List<Nota> listar() {
        return notaDAO.listar();
    }

    public String actualizar(Nota nota) throws Exception {
        return notaDAO.actualizar(nota);
    }

    public void eliminar(String id) throws Exception {
        notaDAO.eliminar(id);
    }

    public Optional<Nota> buscar(String id) {
        return notaDAO.buscar(id);
    }
}
