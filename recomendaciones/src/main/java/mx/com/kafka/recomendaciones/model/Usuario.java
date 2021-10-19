package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.kafka.recomendaciones.constant.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 2463516973461824241L;
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Email
    @Column(unique = true)
    private String correo;
    @Positive
    private Integer edad;
    @NotEmpty
    private String password;

    @ManyToMany
    @JoinTable(
            name = "usuario_genero",
            joinColumns = @JoinColumn(name = " id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generosUsuario;


//    @ManyToMany
//    @JoinTable(
//            name = "usuario_libro",
//            joinColumns = @JoinColumn(name = " id_usuario"),
//            inverseJoinColumns = @JoinColumn(name = "id_libro")
//    )
//    private List<Libro> librosUsuario;


    @Builder.Default
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean expiredAccount = false;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean lockedAccount = false;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean expiredCredentials = false;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean enabled = true;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
