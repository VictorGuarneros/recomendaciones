package mx.com.kafka.recomendaciones.handler;

import mx.com.kafka.recomendaciones.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RepositoryEventHandler
public class UsuarioRepositoryHandler {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @HandleBeforeCreate
    public void handleUsuario(Usuario usuario) {
        System.out.println("handleUsuario: " + usuario);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        System.out.println("handleUsuario: " + usuario);
    }
}
