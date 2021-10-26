package mx.com.kafka.recomendaciones.converter;

import mx.com.kafka.recomendaciones.model.id.UsuarioGeneroId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioGeneroIdConverter implements Converter<String, UsuarioGeneroId> {
    
    @Override
    public UsuarioGeneroId convert(String s) {
        String[] data = s.split(",");
        return UsuarioGeneroId.builder()
                .idUsuario(Integer.valueOf(data[0]))
                .idGenero(Integer.valueOf(data[1]))
                .build();
    }
}
