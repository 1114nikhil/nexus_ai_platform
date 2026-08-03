package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.security.TokenType;
import com.nexus.common.domain.valueobject.Email;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class JwtDecoder {
    private final SecretKey key;

    public JwtDecoder(JwtProperties jwtProperties) {
        this.key = Keys.hmacShaKeyFor(
                jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8)
        );
    }

    public JwtClaims parse(String token){
        Claims claims=Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();

        return new JwtClaims(
                UUID.fromString(claims.get("uid",String.class)),
                new Email(claims.getSubject()),
                Set.copyOf(claims.get("roles", List.class)),
                UUID.fromString(claims.get("tenant",String.class)),
                TokenType.valueOf(claims.get("type",String.class))
        );
    }
}
