package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Libro;
import mx.com.kafka.recomendaciones.model.Usuario;
import mx.com.kafka.recomendaciones.model.UsuarioLibro;
import mx.com.kafka.recomendaciones.model.id.UsuarioLibroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "usuarioslibros", path = "usuarioslibros")
public interface UsuarioLibroRepositorio extends JpaRepository<UsuarioLibro, UsuarioLibroId> {
    List<UsuarioLibro> findByUsuario(Usuario usuario);

    List<UsuarioLibro> findByLibro(Libro libro);
}
