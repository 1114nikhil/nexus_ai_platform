package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.security.TokenType;
import com.nexus.common.domain.valueobject.Email;

import java.util.Set;
import java.util.UUID;

public record JwtClaims(
        UUID userId,
        Email email,
        Set<String> roles,
        UUID tenantId,
        TokenType tokenType
) {
}
