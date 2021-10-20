package mx.com.kafka.recomendaciones.repository;

import mx.com.kafka.recomendaciones.dto.LibroDto;
import mx.com.kafka.recomendaciones.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "libros", path = "libros")
public interface LibroRepositorio extends JpaRepository<Libro, Integer> {

    @Query("SELECT new mx.com.kafka.recomendaciones.dto.LibroDto(l.isbn,l.autor,l.anioPublicacion,l.titulo,l.imagenUrl,l.idioma,l.formato) FROM Libro l")
    List<LibroDto> getAll();

    Optional<Libro> findByIsbn(String isbn);
}
