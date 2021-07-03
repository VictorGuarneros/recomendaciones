package mx.com.kafka.recomendaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.kafka.recomendaciones.model.Genero;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    @NotEmpty
    private String nombre;
    @Positive
    private Integer edad;
    @NotEmpty
    private String password;
    private List <Genero> generos;
}
