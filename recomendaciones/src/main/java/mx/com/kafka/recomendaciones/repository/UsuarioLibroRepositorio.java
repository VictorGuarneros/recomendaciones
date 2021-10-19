package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Libro;
import mx.com.kafka.recomendaciones.model.Usuario;
import mx.com.kafka.recomendaciones.model.UsuarioLibro;
import mx.com.kafka.recomendaciones.model.id.UsuarioLibroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioLibroRepositorio extends JpaRepository<UsuarioLibro, UsuarioLibroId> {
    List<UsuarioLibro> findByUsuario(Usuario usuario);

    List<UsuarioLibro> findByLibro(Libro libro);
}
