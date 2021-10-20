package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 4235431869657965633L;

    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @NotEmpty
    @Column(unique = true)
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

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "libro_genero",
//            joinColumns = @JoinColumn(name = " id_libro"),
//            inverseJoinColumns = @JoinColumn(name = "id_genero")
//    )
//    private Set<Genero> generosLibro;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enabled = true;

}