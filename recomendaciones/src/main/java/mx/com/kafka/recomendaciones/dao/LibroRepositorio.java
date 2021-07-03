package mx.com.kafka.recomendaciones.dao;

import mx.com.kafka.recomendaciones.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer>{
}
