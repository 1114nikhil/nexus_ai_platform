package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.model.AuthenticatedUser;
import com.nexus.common.domain.security.TokenType;
import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.common.domain.valueobject.RefreshToken;
import com.nexus.identity.application.port.out.TokenProvider;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider implements TokenProvider {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final JwtProperties jwtProperties;



    @Override
    public AccessToken generateAccessToken(User user) {
        JwtClaims claims = getJwtClaims(user);
        return new AccessToken(
                jwtEncoder.encoding(claims, jwtProperties.getAccessTokenExpiration())
        );
    }

    private static @NonNull JwtClaims getJwtClaims(User user) {
        return new JwtClaims(
                user.getId(),
                user.getEmail(),
                user.getRoles(),
                null,
                TokenType.ACCESS
        );
    }

    @Override
    public RefreshToken generateRefreshToken(User user) {
        JwtClaims claims = getJwtClaims(user);
        return new RefreshToken(jwtEncoder.encoding(claims, jwtProperties.getRefreshTokenExpiration()));
    }

    @Override
    public boolean validate(AccessToken token) {
        try{
            jwtDecoder.parse(token.value());
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public AuthenticatedUser authenticate(AccessToken token) {
        JwtClaims claims = jwtDecoder.parse(token.value());
        return new AuthenticatedUser(
                claims.userId(),
                claims.email(),
                claims.roles(),
                claims.tenantId());
    }
}
