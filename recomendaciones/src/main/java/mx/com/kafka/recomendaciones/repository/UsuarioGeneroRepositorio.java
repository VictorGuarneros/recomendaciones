package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.UsuarioGenero;
import mx.com.kafka.recomendaciones.model.id.UsuarioGeneroId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuariosgeneros", path = "usuariosgeneros")
public interface UsuarioGeneroRepositorio extends CrudRepository<UsuarioGenero, UsuarioGeneroId> {
}
