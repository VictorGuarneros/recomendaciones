package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Set;

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
    @Column(unique = true)
    private String genero;

    @JsonIgnore
    @ManyToMany(mappedBy = "generosLibro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Libro> libros;

    @JsonIgnore
    @ManyToMany(mappedBy = "generosUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Usuario> generosUsuario;
}