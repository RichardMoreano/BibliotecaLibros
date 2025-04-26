package com.duoc.bibliotecaduoc.repository;

import com.duoc.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRespository {

    // Arreglo que guarda todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    // Metodo que retorna todos los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    // Buscar un libro por su id
    public Libro buscarPorId(int id) {
        for(Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // Buscar un libro por su isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Guardar Libro

    public Libro guardar(Libro libro) {
        listaLibros.add(libro);
        return libro;
    }

    // Actualizar libro
    public Libro actualizar(Libro libro) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                id = libro.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(libro.getTitulo());
        libro1.setAutor(libro.getAutor());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setEditorial(libro.getEditorial());
        libro1.setIsbn(libro.getIsbn());
        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    // Eliminar libro
    public void eliminar(int id) {
        // alternativa 1
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }

        // alternativa 2
        int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaLibros.remove(idPosicion);
        }

        // otra alternativa
        listaLibros.removeIf(x -> x.getId() == id);
    }


}
