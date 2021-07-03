package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Libro {
    @Id
    @GeneratedValue
    private Integer idLibro;
    @NotEmpty
    private String isbn;
    @NotEmpty
    private String autor;
    @Positive
    private Integer anioPublicacion;
    @NotEmpty
    private String titulo;
    @NotEmpty
    private String imagenUrl;
    @NotEmpty
    private String idioma;
    @NotEmpty
    private String formato;
}