package negocio.dao;

import java.util.List;
import java.util.Optional;

public interface ICRUD <T, I>{

    I crear(T t);
    List<T> listar();
    I actualizar(T t) throws Exception;
    void eliminar(I id) throws Exception;
    Optional<T> buscar(I id);

}
