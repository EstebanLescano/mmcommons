package org.lea.mmcommons.configurations;

import org.springframework.context.annotation.Bean;

public class ConfigKeycloak {

    private final Key

    @Bean
    public Keycloak keycloakAdmin() { ... }

    @Bean
    public KeycloakTokenRepository keycloakTokenRepository() {
        return new KeycloakTokenRepository();
    }

}
