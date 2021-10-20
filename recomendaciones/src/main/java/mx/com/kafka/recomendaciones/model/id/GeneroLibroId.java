package mx.com.kafka.recomendaciones.model.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GeneroLibroId implements Serializable {
    private static final long serialVersionUID = 6079513751878438605L;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "id_libro")
    private Integer idLibro;
}
