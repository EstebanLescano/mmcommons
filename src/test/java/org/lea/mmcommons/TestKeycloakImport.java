package org.lea.mmcommons;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.OAuth2Constants;

public class TestKeycloakImport {
    public static void main(String[] args) {
        Keycloak kc = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("mmdev")
                .clientId("admin-cli")
                .username("admin")
                .password("admin")
                .grantType(OAuth2Constants.PASSWORD)
                .build();
        System.out.println("Keycloak creado: " + kc);
    }
}

