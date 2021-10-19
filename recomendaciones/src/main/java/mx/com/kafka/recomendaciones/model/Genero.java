package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Genero implements Serializable {
    private static final long serialVersionUID = -1308234102080659373L;
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;
    @NotEmpty
    private String genero;
    @ManyToMany(mappedBy = "generosLibro")
    private List<Libro> libros;

    @ManyToMany(mappedBy = "generosUsuario")
    private List<Usuario> generosUsuario;
}