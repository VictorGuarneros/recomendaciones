package mx.com.kafka.recomendaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public CorsConfigurationSource getConfigurationSource() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource;
        urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("*")); // dev && prod url
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
        return urlBasedCorsConfigurationSource;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http//
                .csrf().disable()
                .authorizeRequests()//
                .antMatchers(HttpMethod.GET, "/oauth/**").permitAll() //
                .antMatchers(HttpMethod.POST, "/oauth/**").permitAll() //
                .antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll() //
                .antMatchers(HttpMethod.GET, "/api/generos/**").permitAll() //
                .antMatchers(HttpMethod.POST, "/api/usuarios/**").permitAll() //
                .antMatchers(HttpMethod.POST, "/api/usuariosgeneros/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .anyRequest().authenticated() //
                .and().cors().configurationSource(getConfigurationSource());
    }
}
