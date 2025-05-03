package com.duoc.bibliotecaduoc.service;


import com.duoc.bibliotecaduoc.model.Libro;
import com.duoc.bibliotecaduoc.repository.LibroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRespository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(@PathVariable Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(@PathVariable int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(@PathVariable Libro libro) {
        return libroRepository.actualizar(libro);
    }

    public Libro buscarLibroPorIsbn(@PathVariable String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }

    public int buscarPorAnio(@PathVariable int anio) {
        return libroRepository.buscarPorAnio(anio);
    }

    public Libro buscarPorAutor(@PathVariable String autor) {
        return libroRepository.buscarPorAutor(autor);
    }

    public Libro libroMasAntiguo() {
        return libroRepository.libroMasAntiguoV2();
    }

    public Libro libroMasNuevo() {
        return libroRepository.libroMasNuevoV2();
    }

    public List<Libro> listarLibroPorAnioV2() {
        return libroRepository.listarLibroPorAnioV2();
    }





    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

    public int totalLibrosV1() {
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }


}
