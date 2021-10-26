package mx.com.kafka.recomendaciones.converter;

import mx.com.kafka.recomendaciones.model.id.GeneroLibroId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GeneroLibroIdConverter implements Converter<String, GeneroLibroId> {
    
    @Override
    public GeneroLibroId convert(String s) {
        String[] data = s.split(",");
        return GeneroLibroId.builder()
                .idGenero(Integer.valueOf(data[0]))
                .idLibro(Integer.valueOf(data[1]))
                .build();
    }
}
