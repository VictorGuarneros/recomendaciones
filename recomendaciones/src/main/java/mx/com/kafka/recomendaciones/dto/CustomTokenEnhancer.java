package mx.com.kafka.recomendaciones.dto;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        UserDetailsImpl user = (UserDetailsImpl) oAuth2Authentication.getPrincipal();
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", user.getUser().getNombre());
        properties.put("edad", user.getUser().getEdad());
        properties.put("rol", user.getUser().getRole());
        properties.put("idUsuario", user.getUser().getIdUsuario());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(properties);
        return oAuth2AccessToken;
    }
}
