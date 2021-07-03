package mx.com.kafka.recomendaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Integer idUsuario;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Email
    @Column(unique=true)
    private String correo;
    @Positive
    private Integer edad;
    @NotEmpty
    private String password;
    @ManyToMany
    private List <Genero> generos;
}
