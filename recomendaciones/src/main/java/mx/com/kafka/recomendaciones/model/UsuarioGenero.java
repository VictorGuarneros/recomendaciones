package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.kafka.recomendaciones.model.id.UsuarioGeneroId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioGenero implements Serializable {
    private static final long serialVersionUID = -1324208396134537691L;

    @EmbeddedId
    private UsuarioGeneroId usuarioGeneroId;

    public Integer getIdUsuario() {
        return usuarioGeneroId.getIdUsuario();
    }

    public Integer getIdGenero() {
        return usuarioGeneroId.getIdGenero();
    }


//    @NotNull
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @MapsId("id_usuario")
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;
//
//    @NotNull
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @MapsId("id_genero")
//    @JoinColumn(name = "id_genero")
//    private Genero genero;

}
