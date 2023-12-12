package negocio.dao.factory;

import negocio.dao.ICRUD;
import negocio.model.notas.Nota;
import java.util.List;
import java.util.Optional;

public class PersistenciaNotasFactory implements ICRUD<Nota, String> {

    private final ICRUD<Nota,String> notaDAO;

    public PersistenciaNotasFactory(ICRUD<Nota,String> notaDAO ) {
        this.notaDAO = notaDAO;
    }

    @Override
    public String crear(Nota nota) {
        return notaDAO.crear(nota);
    }

    @Override
    public List<Nota> listar() {
        return notaDAO.listar();
    }

    @Override
    public String actualizar(Nota nota) throws Exception {
        return notaDAO.actualizar(nota);
    }

    @Override
    public void eliminar(String id) throws Exception {
        notaDAO.eliminar(id);
    }

    @Override
    public Optional<Nota> buscar(String id) {
        return notaDAO.buscar(id);
    }
}
