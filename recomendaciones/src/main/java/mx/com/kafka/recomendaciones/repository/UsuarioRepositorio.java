package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);

//    @Query("SELECT new mx.com.kafka.recomendaciones.dto.UsuarioDto(u.nombre, u.correo, u.edad, u.password) FROM Usuario u WHERE u.enabled = 1")
//    List<UsuarioDto> findAllEnabled();

}
