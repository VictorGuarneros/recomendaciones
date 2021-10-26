package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Calificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "calificaciones", path = "calificaciones")
public interface CalificacionRepositorio extends CrudRepository<Calificacion, Integer> {

}
