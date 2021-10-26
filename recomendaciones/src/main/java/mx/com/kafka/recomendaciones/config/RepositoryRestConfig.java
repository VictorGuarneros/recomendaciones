package mx.com.kafka.recomendaciones.config;

import mx.com.kafka.recomendaciones.converter.GeneroLibroIdConverter;
import mx.com.kafka.recomendaciones.converter.UsuarioGeneroIdConverter;
import mx.com.kafka.recomendaciones.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private GeneroLibroIdConverter generoLibroIdConverter;

    @Autowired
    private UsuarioGeneroIdConverter usuarioGeneroIdConverter;

//    @Autowired
//    private UsuarioLibroIdConverter usuarioLibroIdConverter;


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Usuario.class);
        config.exposeIdsFor(Genero.class);
        config.exposeIdsFor(Libro.class);

        config.exposeIdsFor(UsuarioGenero.class);
//        config.exposeIdsFor(Usuariolibro.class);
        config.exposeIdsFor(GeneroLibro.class);
    }

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {
        conversionService.addConverter(generoLibroIdConverter);
        conversionService.addConverter(usuarioGeneroIdConverter);
//        conversionService.addConverter(usuarioLibroIdConverter);
    }
}
