package org.lea.mmcommons.repositories;

@Repository
public class KeycloakTokenRepository {

    @Value("${keycloak.server.url}")
    private String serverUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client.id}")
    private String clientId;

    @Value("${keycloak.client.secret}")
    private String clientSecret;

    @Value("${keycloak.master.realm}")
    private String masterRealm;

    @Value("${keycloak.master.client.id}")
    private String masterClientId;

    @Value("${keycloak.master.client.secret}")
    private String masterClientSecret;

    /**
     * Obtener token de cliente (client credentials)
     */
    public AccessTokenResponse getClientToken() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build()
                .tokenManager()
                .getAccessToken();
    }

    /**
     * Obtener token master para administración
     */
    public AccessTokenResponse getMasterToken() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(masterRealm)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(masterClientId)
                .clientSecret(masterClientSecret)
                .build()
                .tokenManager()
                .getAccessToken();
    }

    /**
     * Token exchange (impersonación)
     */
    public AccessTokenResponse exchangeToken(String subjectToken, String requestedFor) {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.TOKEN_EXCHANGE)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .param("subject_token", subjectToken)
                .param("requested_subject", requestedFor)
                .build()
                .tokenManager()
                .getAccessToken();
    }

    /**
     * Crear instancia de Keycloak Admin Client
     */
    public Keycloak getKeycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(masterRealm)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(masterClientId)
                .clientSecret(masterClientSecret)
                .build();
    }
}
