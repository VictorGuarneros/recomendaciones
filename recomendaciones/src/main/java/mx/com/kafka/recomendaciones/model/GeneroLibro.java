package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.kafka.recomendaciones.model.id.GeneroLibroId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GeneroLibro implements Serializable {
    private static final long serialVersionUID = 3941388628582576178L;

    @EmbeddedId
    private GeneroLibroId generoLibroId;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("id_genero")
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("id_libro")
    @JoinColumn(name = "id_libro")
    private Libro libro;
}
