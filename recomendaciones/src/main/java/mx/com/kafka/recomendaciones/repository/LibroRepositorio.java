package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.model.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "libros", path = "libros")
public interface LibroRepositorio extends CrudRepository<Libro, Integer> {

//    @Query("SELECT new mx.com.kafka.recomendaciones.dto.LibroDto(l.isbn,l.autor,l.anioPublicacion,l.titulo,l.imagenUrl,l.idioma,l.formato) FROM Libro l")
//    List<LibroDto> getAll();

    Optional<Libro> findByIsbn(String isbn);
}
