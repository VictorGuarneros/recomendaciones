package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Genero {
    @Id
    @GeneratedValue
    @Positive
    private Integer idGenero;
    @NotEmpty
    private String genero;
    @ManyToMany
    private List<Libro> libros;
}