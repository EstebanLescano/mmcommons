package org.lea.mmcommons.services;

import jakarta.ws.rs.core.Response;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserKeycloakService {

    private final Keycloak keycloakAdmin;

    public UserKeycloakService(@Qualifier("keycloakAdminClient") Keycloak keycloakAdmin) {
        this.keycloakAdmin = keycloakAdmin;
    }

    public String createUser(String username, String password) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEnabled(true);

        Response response = keycloakAdmin.realm("mmrealm").users().create(user);
        String userId = CreatedResponseUtil.getCreatedId(response);

        // Set password
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);

        keycloakAdmin.realm("mmrealm").users().get(userId).resetPassword(credential);
        return userId;
    }

    public String login(String username, String password) {
        Keycloak keycloakUser = KeycloakBuilder.builder()
//                .serverUrl(keycloakAdmin.getServerUrl())
//                .realm(realm)
                .clientId("app-console") // tu cliente donde quieres login
                .username(username)
                .password(password)
                .grantType(OAuth2Constants.PASSWORD)
                .build();

        AccessTokenResponse tokenResponse = keycloakUser.tokenManager().getAccessToken();
        return tokenResponse.getToken();
    }
}

