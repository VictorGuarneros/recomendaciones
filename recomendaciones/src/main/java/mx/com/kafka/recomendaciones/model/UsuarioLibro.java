package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.kafka.recomendaciones.model.id.UsuarioLibroId;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UsuarioLibro implements Serializable {

    private static final long serialVersionUID = -7106820489523351253L;
    @EmbeddedId
    private UsuarioLibroId id;

    @NotNull
    @OneToOne
    @MapsId("id_usuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull
    @OneToOne
    @MapsId("id_libro")
    @JoinColumn(name = "id_libro")
    private Libro libro;


    @Max(10)
    @Min(1)
    private Integer puntuacion;

}
