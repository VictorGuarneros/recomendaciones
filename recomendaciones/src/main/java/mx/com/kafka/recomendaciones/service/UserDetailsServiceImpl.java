package mx.com.kafka.recomendaciones.service;

import lombok.AllArgsConstructor;
import mx.com.kafka.recomendaciones.dto.UserDetailsImpl;
import mx.com.kafka.recomendaciones.model.Usuario;
import mx.com.kafka.recomendaciones.repository.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepositorio userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository
                .findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("User was not found"));
        System.out.println(user.isEnabled());
        return UserDetailsImpl.builder().user(user).build();
    }
}
