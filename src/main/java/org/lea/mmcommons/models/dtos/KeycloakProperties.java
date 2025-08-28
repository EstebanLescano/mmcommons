package org.lea.mmcommons.models.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties {
    private String serverUrl;
    private Admin admin;
    private Client client;

    @Data
    public static class Admin {
        private String realm;
        private String clientId;
        private String username;
        private String password;
    }

    @Data
    public static class Client {
        private String realm;
        private String clientId;
        private String clientSecret;
    }
}

