package negocio.dao.archivo;

import negocio.dao.repositorios.NotasRepository;
import negocio.model.notas.Nota;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotaArchivoDAO implements NotasRepository {

    private static final String RUTA = "src/main/resources/datos/notas.ser";

    @Override
    public String crear(Nota nota) {

        try{

            List<Nota> notas = listar();
            notas.add(nota);

            serializar(notas);

            return nota.getCodigo();

        }catch (IOException e){
            throw new RuntimeException("Error al leer el archivo") ;
        }

    }

    @Override
    public List<Nota> listar() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA));
            ArrayList<Nota> objeto = (ArrayList<Nota>) ois.readObject();

            return objeto;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al leer el archivo") ;
        }

    }

    @Override
    public String actualizar(Nota nota) throws Exception {

        List<Nota> notas = listar();

        int indice = notas.indexOf(nota);
        notas.set(indice, nota);

        serializar(notas);

        return nota.getCodigo();
    }

    @Override
    public void eliminar(String id) throws Exception {

        List<Nota> notas = listar();

        for (Nota nota : notas) {
            if (nota.getCodigo().equals(id)) {
                notas.remove(nota);
                break;
            }
        }

        serializar(notas);

    }

    @Override
    public Optional<Nota> buscar(String id) {
        List<Nota> notas = listar();

        for (Nota nota : notas) {
            if (nota.getCodigo().equals(id)) {
                return Optional.of(nota);
            }
        }

        return Optional.empty();

    }

    private void serializar(Object objeto) throws IOException{

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA));
        oos.writeObject(objeto);
        oos.close();

    }

}
