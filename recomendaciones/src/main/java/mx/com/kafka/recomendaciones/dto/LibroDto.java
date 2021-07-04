package mx.com.kafka.recomendaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {
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
}
