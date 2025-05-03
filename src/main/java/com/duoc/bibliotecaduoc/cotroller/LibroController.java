package com.duoc.bibliotecaduoc.cotroller;

import com.duoc.bibliotecaduoc.model.Libro;
import com.duoc.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

        @Autowired
        private LibroService libroService;

        @GetMapping
        public List<Libro> listarLibros () {
            return libroService.getLibros ();
        }

        @PostMapping
        public Libro agregarLibro(@RequestBody Libro libro) {

            return libroService.saveLibro(libro);
        }

        @GetMapping("{id}")
        public Libro buscarLibro(@PathVariable int id){

            return libroService.getLibroId(id);
        }

        @PutMapping("{id}")
        public Libro actualizarLibro (@PathVariable int id, @RequestBody Libro libro){
            // el id lo usaremos mas adelante
            return libroService.updateLibro(libro);
        }

        @DeleteMapping("{id}")
        public String eliminarlibro (@PathVariable int id) {

            return libroService.deleteLibro(id);
        }

        @GetMapping("/total")
        public int totalLibrosV2() {
            return libroService.totalLibrosV1();
        }

        @GetMapping("/isbn/{isbn}")
        public String buscarLibroIsbn(@PathVariable String isbn) {
            Libro libro = libroService.buscarLibroPorIsbn(isbn);
            if (libro != null) {
                return libro.toString();
            } else {
                return "Libro no encontrado";
            }
        }

        @GetMapping("/cantidadPorAnio/{anio}")
        public int buscarPorAnio(@PathVariable int anio) {
            return libroService.buscarPorAnio(anio);
        }

        @GetMapping("/autor/{autor}")
        public String buscarPorAutor(@PathVariable String autor) {
            Libro libro = libroService.buscarPorAutor(autor);
            if (libro != null) {
                return libro.toString();
            } else {
                return "Autor no encontrado";
            }
        }

        @GetMapping("/masAntiguo")
        public Libro libroMasAntiguo() {
            return libroService.libroMasAntiguo();
        }

        @GetMapping("/masNuevo")
        public Libro libroMasNuevo() {
            return libroService.libroMasNuevo();
        }

        @GetMapping("/listarEnOrden")
        public List<Libro> listarLibroPorAnioV2() {
            return libroService.listarLibroPorAnioV2();
        }
}
