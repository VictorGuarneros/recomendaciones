package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "generos", path = "generos")
public interface GeneroRepositorio extends JpaRepository<Genero, Integer> {
}
