package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.GeneroLibro;
import mx.com.kafka.recomendaciones.model.id.GeneroLibroId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "generoslibros", path = "generoslibros")
public interface GeneroLibroRepositorio extends CrudRepository<GeneroLibro, GeneroLibroId> {
}
