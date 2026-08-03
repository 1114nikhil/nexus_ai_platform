package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.security.TokenType;
import com.nexus.common.domain.valueobject.Email;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Component
public class JwtEncoder {
    private final SecretKey key;

    public JwtEncoder(JwtProperties jwtProperties) {
        this.key = Keys.hmacShaKeyFor(
                jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }



    public String encoding(JwtClaims jwtClaims, long expiration){
        return Jwts.builder()
                .subject(jwtClaims.email().value())
                .claim("uid",jwtClaims.userId())
                .claim("roles",jwtClaims.roles())
                .claim("tenant",jwtClaims.tenantId())
                .claim("type",jwtClaims.tokenType())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(key)
                .compact();
    }
}
