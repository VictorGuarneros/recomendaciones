package mx.com.kafka.recomendaciones.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {

    @Bean
    public UsuarioRepositoryHandler personEventHandler() {
        return new UsuarioRepositoryHandler();
    }
}
