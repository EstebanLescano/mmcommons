package org.lea.mmcommons.services;

import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.lea.mmcommons.repositories.KeycloakTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${keycloak.auth-server-url}")
    private String serverUrl;

    @Value("${keycloak.admin.realm}")
    private String adminRealm;

    @Value("${keycloak.admin.client-id}")
    private String adminClientId;

    @Value("${keycloak.admin.client-secret}")
    private String adminClientSecret;

    @Value("${keycloak.client.realm}")
    private String clientRealm;

    @Value("${keycloak.client-id}")
    private String clientId;

    /**
     * 1️⃣ Obtener token de admin (client_credentials)
     */
    public AccessTokenResponse getAdminToken() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(adminRealm)
                .clientId(adminClientId)
                .clientSecret(adminClientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();

        return keycloak.tokenManager().getAccessToken();
    }

    /**
     * 2️⃣ Login de usuario (password grant)
     */
    public AccessTokenResponse loginUser(String username, String password) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(clientRealm)
                .clientId(clientId)
                .username(username)
                .password(password)
                .grantType(OAuth2Constants.PASSWORD)
                .build();

        return keycloak.tokenManager().getAccessToken();
    }

    /**
     * 3️⃣ Impersonación (token exchange)
     */
//    public Keycloak impersonate(String adminToken, String targetUsername) {

//        final KeycloakTokenRepository tokenRepository;
//
//        Keycloak keycloak = KeycloakBuilder.builder()
//                .serverUrl(serverUrl)
//                .realm(adminRealm)
//                .clientId(adminClientId)
//                .authorization(adminToken)
//                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
//                .build();
//        return keycloak;
//    }
}

