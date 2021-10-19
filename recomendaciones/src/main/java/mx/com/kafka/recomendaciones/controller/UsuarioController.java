package mx.com.kafka.recomendaciones.controller;

import mx.com.kafka.recomendaciones.constant.Role;
import mx.com.kafka.recomendaciones.dto.UsuarioDto;
import mx.com.kafka.recomendaciones.model.Usuario;
import mx.com.kafka.recomendaciones.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UsuarioDto> getUsuarios(@RequestParam String correo) {
        if (correo == null || correo.isEmpty()) {
            return repositorio.findAllEnabled();
        }
        List<UsuarioDto> dtos = new ArrayList<>();
        Optional<Usuario> byCorreo = repositorio.findByCorreo(correo);
        if (byCorreo.isPresent()) {
            Usuario usuario = byCorreo.get();
            dtos.add(UsuarioDto.builder()
                    .nombre(usuario.getNombre())
                    .correo(usuario.getCorreo())
                    .edad(usuario.getEdad())
                    .build());
        }
        return dtos;
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuarios(@Valid @RequestBody UsuarioDto dto) {
        try {
            return new ResponseEntity<>(repositorio.save(Usuario.builder()
                    .correo(dto.getCorreo())
                    .nombre(dto.getNombre())
                    .edad(dto.getEdad())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .enabled(true)
                    .role(Role.CLIENT)
                    .build()), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuarios(@Valid @RequestBody UsuarioDto usuario, @RequestParam String correo) {
        Optional<Usuario> byId = repositorio.findByCorreo(correo);
        if (byId.isPresent()) {
            Usuario usuario1 = byId.get();
            usuario1.setNombre(usuario.getNombre());
            usuario1.setCorreo(usuario.getCorreo());
            usuario1.setEdad(usuario.getEdad());
            usuario1.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return new ResponseEntity<>(repositorio.save(usuario1), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<Usuario> deleteUsuarios(@RequestParam String correo) {
        Optional<Usuario> byId = repositorio.findByCorreo(correo);
        if (byId.isPresent()) {
            Usuario usuario = byId.get();
            usuario.setEnabled(false);
            repositorio.save(usuario);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
