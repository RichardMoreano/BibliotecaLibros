package com.duoc.bibliotecaduoc.repository;

import com.duoc.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LibroRespository {

    // Arreglo que guarda todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //  Agregar libros por defecto
    public LibroRespository() {
    listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
    listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
    listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
    listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
    listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
    listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
    listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch"));
    listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice 2 ESCUELA DE ADMINISTRACIÓN Y NEGOCIOS Hall", 2017, "Robert C. Martin"));
    listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
    listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall",2008, "Robert C. Martin"));
    }
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

    // Cantidad libros por año
    public int buscarPorAnio(int anio) {
        int cont = 0;
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() == anio) {
                cont ++;
            }
        }
        return cont;
    }

    // Buscar Por Autor
    public Libro buscarPorAutor(String autor) {
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }

    // Buscar Libro mas Antiguo
    public Libro libroMasAntiguoV2() {
        listaLibros.sort(Comparator.comparing(Libro::getFechaPublicacion));
        return listaLibros.get(0);
    }

    // Buscar Libro mas Nuevo
    public Libro libroMasNuevoV2() {
        listaLibros.sort(Comparator.comparing(Libro::getFechaPublicacion).reversed());
        return listaLibros.get(0);
    }

    // Listar todos los libros por año de publicación
    public List<Libro> listarLibroPorAnioV2() {
        listaLibros.sort(Comparator.comparing(Libro::getFechaPublicacion));
        return listaLibros;
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

    // CUENTA LA CANTIDAD DE LIBROS QUE HAY EN LA LISTA
    public int totalLibros() {
        return listaLibros.size();
    }

}
