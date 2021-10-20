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
public class UsuarioGeneroId implements Serializable {
    private static final long serialVersionUID = 8379701279561264311L;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_genero")
    private Integer idGenero;
}
