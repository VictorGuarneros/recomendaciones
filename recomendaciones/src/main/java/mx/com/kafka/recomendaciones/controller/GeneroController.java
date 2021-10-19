package mx.com.kafka.recomendaciones.controller;

import mx.com.kafka.recomendaciones.dto.GeneroDto;
import mx.com.kafka.recomendaciones.model.Genero;
import mx.com.kafka.recomendaciones.repository.GeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepositorio repositorio;

    @GetMapping
    public List<Genero> getGeneros() {
        return repositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Genero> saveGeneros(@Valid @RequestBody Genero genero) {
        try {
            return new ResponseEntity<>(repositorio.save(genero), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Genero> updateGeneros(@Valid @RequestBody GeneroDto genero, @RequestParam Integer idGenero) {
        Optional<Genero> byId = repositorio.findById(idGenero);
        if (byId.isPresent()) {
            Genero genero1 = byId.get();
            genero1.setGenero(genero.getGenero());
//            genero1.setLibros(genero.getLibros());
            return new ResponseEntity<>(repositorio.save(genero1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Genero> deleteGenero(@RequestParam Integer idGenero) {
        Optional<Genero> byId = repositorio.findById(idGenero);
        if (byId.isPresent()) {
            repositorio.deleteById(idGenero);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
