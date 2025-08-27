package org.lea.mmcommons.models.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties {
    private String serverUrl;
    //master admin
    private String masterRealm;
    private String adminClientId;
    private String masterUsername;
    private String masterPassword;
    //client(app)
    private String clientRealm;
    private String clientId;
    private String clientSecret;
}

