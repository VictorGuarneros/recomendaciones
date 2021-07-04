package mx.com.kafka.recomendaciones.controller;

import mx.com.kafka.recomendaciones.dao.UsuarioRepositorio;
import mx.com.kafka.recomendaciones.dto.UsuarioDto;
import mx.com.kafka.recomendaciones.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio repositorio;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return repositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuarios(@Valid @RequestBody Usuario usuario) {
        try {
            // if(usuario == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(repositorio.save(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuarios(@Valid @RequestBody UsuarioDto usuario, @RequestParam Integer idUsuario) {
        Optional<Usuario> byId = repositorio.findById(idUsuario);
        if (byId.isPresent()) {
            Usuario usuario1 = byId.get();
            usuario1.setEdad(usuario.getEdad());
            usuario1.setPassword(usuario.getPassword());
            usuario1.setNombre(usuario.getNombre());
            usuario1.setGeneros(usuario.getGeneros());
            return new ResponseEntity<>(repositorio.save(usuario1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Usuario> deleteUsuarios(@RequestParam Integer idUsuario)
    {
        Optional<Usuario> byId = repositorio.findById(idUsuario);
        if(byId.isPresent())
        {
            repositorio.deleteById(idUsuario);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}