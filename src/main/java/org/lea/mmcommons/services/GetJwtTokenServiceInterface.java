package org.lea.mmcommons.services;

import org.springframework.security.oauth2.jwt.Jwt;

public interface GetJwtTokenServiceInterface {
    Jwt getJwt();
}
