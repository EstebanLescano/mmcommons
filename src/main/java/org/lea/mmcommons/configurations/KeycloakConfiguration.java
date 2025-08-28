package org.lea.mmcommons.configurations;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.lea.mmcommons.models.dtos.KeycloakProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KeycloakProperties.class)
public class KeycloakConfiguration {

    private final KeycloakProperties properties;

    public KeycloakConfiguration(KeycloakProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Keycloak keycloakAdmin() {
        return KeycloakBuilder.builder()
                .serverUrl(properties.getServerUrl())
                .realm(properties.getAdmin().getRealm())
                .username(properties.getAdmin().getUsername())
                .password(properties.getAdmin().getPassword())
                .clientId(properties.getAdmin().getClientId())
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }

    @Bean
    public Keycloak keycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl(properties.getServerUrl())
                .realm(properties.getClient().getRealm())
                .clientId(properties.getClient().getClientId())
                .clientSecret(properties.getClient().getClientSecret())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}

