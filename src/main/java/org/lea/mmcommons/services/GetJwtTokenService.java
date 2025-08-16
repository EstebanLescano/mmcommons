package org.lea.mmcommons.services;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class GetJwtTokenService implements GetJwtTokenServiceInterface {

    public Jwt getJwt() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        JwtAuthenticationToken authentication = (JwtAuthenticationToken)securityContext.getAuthentication();
        return authentication.getToken();
    }
}
