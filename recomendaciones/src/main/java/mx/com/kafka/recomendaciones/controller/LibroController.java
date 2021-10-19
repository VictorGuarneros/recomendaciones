package mx.com.kafka.recomendaciones.controller;

import mx.com.kafka.recomendaciones.dto.LibroDto;
import mx.com.kafka.recomendaciones.model.Libro;
import mx.com.kafka.recomendaciones.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroRepositorio repositorio;

    @GetMapping
    public List<LibroDto> getLibros(@RequestParam String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return repositorio.getAll();
        }

        List<LibroDto> dtos = new ArrayList<>();
        Optional<Libro> byIsbn = repositorio.findByIsbn(isbn);
        if (byIsbn.isPresent()) {
            Libro libro = byIsbn.get();
            dtos.add(LibroDto.builder()
                    .isbn(isbn).autor(libro.getAutor().toUpperCase())
                    .anioPublicacion(libro.getAnioPublicacion())
                    .titulo(libro.getTitulo().toUpperCase()).imagenUrl(libro.getImagenUrl())
                    .idioma(libro.getIdioma().toUpperCase()).formato(libro.getFormato().toUpperCase())
                    .build());
        }
        return dtos;

    }

    @PostMapping
    public ResponseEntity<Libro> saveLibros(@Valid @RequestBody LibroDto dto) {
        try {
            return new ResponseEntity<>(repositorio.save(Libro.builder()
                    .anioPublicacion(dto.getAnioPublicacion())
                    .isbn(dto.getIsbn().toUpperCase()).autor(dto.getAutor().toUpperCase())
                    .idioma(dto.getIdioma().toUpperCase()).formato(dto.getFormato().toUpperCase())
                    .titulo(dto.getTitulo().toUpperCase()).imagenUrl(dto.getImagenUrl())
                    .build()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Libro> updateLibros(@Valid @RequestBody LibroDto libro, @RequestParam String isbn) {
        Optional<Libro> byIsbn = repositorio.findByIsbn(isbn);
        if (byIsbn.isPresent()) {
            Libro libro1 = byIsbn.get();
            libro1.setAutor(libro.getAutor().toUpperCase());
            libro1.setAnioPublicacion(libro.getAnioPublicacion());
            libro1.setTitulo(libro.getTitulo().toUpperCase());
            libro1.setImagenUrl(libro.getImagenUrl());
            libro1.setIdioma(libro.getIdioma().toUpperCase());
            libro1.setFormato(libro.getFormato().toUpperCase());
            return new ResponseEntity<>(repositorio.save(libro1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Libro> deleteLibro(@RequestParam String isbn) {
        Optional<Libro> byIsbn = repositorio.findByIsbn(isbn);
        if (byIsbn.isPresent()) {
            Libro libro = byIsbn.get();
            libro.setEnabled(false);
            repositorio.save(libro);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
