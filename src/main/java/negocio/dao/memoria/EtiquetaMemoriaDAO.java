package negocio.dao.memoria;

import negocio.dao.ICRUD;
import negocio.model.Etiqueta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EtiquetaMemoriaDAO implements ICRUD<Etiqueta, String> {

    private final List<Etiqueta> etiquetas;

    public EtiquetaMemoriaDAO() {
        this.etiquetas = new ArrayList<>();
    }

    @Override
    public String crear(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
        return etiqueta.getNombre();
    }

    @Override
    public List<Etiqueta> listar() {
        return this.etiquetas;
    }

    @Override
    public String actualizar(Etiqueta etiqueta) {
        int etiquetaEncontrada = this.etiquetas.indexOf(etiqueta);

        if(etiquetaEncontrada == -1)
            throw new RuntimeException("No existe una etiqueta con el nombre " + etiqueta.getNombre());

        this.etiquetas.set(etiquetaEncontrada, etiqueta);
        return etiqueta.getNombre();
    }

    @Override
    public void eliminar(String nombre) {

        Optional<Etiqueta> etiquetaOptional = buscar(nombre);

        if(etiquetaOptional.isEmpty())
            throw new RuntimeException("No existe una etiqueta con el nombre " + nombre);

        this.etiquetas.remove(etiquetaOptional.get());
    }

    @Override
    public Optional<Etiqueta> buscar(String nombre) {
        Etiqueta etiqueta = this.etiquetas.stream().filter(e -> e.getNombre().equals(nombre)).findFirst().orElse(null);

        if(etiqueta == null)
            return Optional.empty();

        return Optional.of(etiqueta);
    }

    public List<Etiqueta> listarEtiquetasPorNombre(String nombre) {
        return this.etiquetas.stream().filter( etiqueta -> etiqueta.getNombre().toLowerCase().contains(nombre.toLowerCase()) ).toList();
    }

    public List<Etiqueta> listarEtiquetasPorColor(String color) {
        return this.etiquetas.stream().filter( etiqueta -> etiqueta.getColor().toLowerCase().contains(color.toLowerCase()) ).toList();
    }

}
