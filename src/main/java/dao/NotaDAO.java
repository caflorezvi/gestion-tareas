package dao;

import model.Nota;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotaDAO implements ICRUD<Nota, String> {

    private final List<Nota> notas;

    public NotaDAO() {
        this.notas = new ArrayList<>();
    }

    @Override
    public String crear(Nota nota) {
        this.notas.add(nota);
        return nota.getCodigo();
    }

    @Override
    public List<Nota> listar() {
        return this.notas;
    }

    @Override
    public String actualizar(Nota nota) throws Exception {
        int index = this.notas.indexOf(nota);

        if(index == -1)
            throw new Exception("No existe una nota con el código " + nota.getCodigo());

        this.notas.set(index, nota);
        return nota.getCodigo();
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        Optional<Nota> notaOptional = buscar(codigo);

        if(notaOptional.isEmpty())
            throw new RuntimeException("No existe una nota con el código " + codigo);

        this.notas.remove(notaOptional.get());
    }

    @Override
    public Optional<Nota> buscar(String id) {
        Nota nota = this.notas.stream().filter(n -> n.getCodigo().equals(id)).findFirst().orElse(null);

        if(nota == null)
            return Optional.empty();

        return Optional.of(nota);
    }

    public List<Nota> listarNotasPorTitulo(String busqueda) {
        return this.listar().stream().filter( nota -> nota.getTitulo().toLowerCase().contains(busqueda.toLowerCase()) ).toList();
    }

    public List<Nota> listarNotasPorEtiqueta(String etiqueta) {
        return this.listar().stream().filter( nota -> nota.getEtiquetas().stream().anyMatch(e -> e.getNombre().toLowerCase().contains(etiqueta.toLowerCase())) ).toList();
    }

}
