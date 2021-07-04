package mx.com.kafka.recomendaciones.controller;

import mx.com.kafka.recomendaciones.dao.LibroRepositorio;
import mx.com.kafka.recomendaciones.dto.LibroDto;
import mx.com.kafka.recomendaciones.dto.UsuarioDto;
import mx.com.kafka.recomendaciones.model.Libro;
import mx.com.kafka.recomendaciones.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroRepositorio repositorio;

    @GetMapping
    public List<Libro> getLibros() {
        return repositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Libro> saveLibros(@Valid @RequestBody Libro libro) {
        try {
            return new ResponseEntity<>(repositorio.save(libro), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Libro> updateLibros(@Valid @RequestBody LibroDto libro, @RequestParam Integer idLibro) {
        Optional<Libro> byId = repositorio.findById(idLibro);
        if (byId.isPresent()) {
            Libro libro1 = byId.get();
            libro1.setAutor(libro.getAutor());
            libro1.setAnioPublicacion(libro.getAnioPublicacion());
            libro1.setTitulo(libro.getTitulo());
            libro1.setImagenUrl(libro.getImagenUrl());
            libro1.setIdioma(libro.getIdioma());
            libro1.setFormato(libro.getFormato());
            return new ResponseEntity<>(repositorio.save(libro1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Libro> deleteLibro(@RequestParam Integer idLibro)
    {
        Optional<Libro> byId = repositorio.findById(idLibro);
        if(byId.isPresent())
        {
            repositorio.deleteById(idLibro);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
