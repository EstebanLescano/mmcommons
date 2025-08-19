package org.lea.mmcommons.services;

import org.keycloak.admin.client.Keycloak;
import org.springframework.stereotype.Service;

@Service
public class KeycloakService {

    private final Keycloak keycloak;

    public KeycloakService(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    public Keycloak getKeycloak() {
        return keycloak;
    }
}

