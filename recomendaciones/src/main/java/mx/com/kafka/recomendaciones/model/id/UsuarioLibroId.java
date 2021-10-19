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
public class UsuarioLibroId implements Serializable {
    private static final long serialVersionUID = 7925169819576995259L;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_libro")
    private Integer idLibro;
}
