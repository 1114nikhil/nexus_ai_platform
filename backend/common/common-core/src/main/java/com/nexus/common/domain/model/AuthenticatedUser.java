package com.nexus.common.domain.model;

import com.nexus.common.domain.valueobject.Email;

import java.util.Set;
import java.util.UUID;

public record AuthenticatedUser(
        UUID userId,
        Email email,
        Set<String> roles,
        UUID tenantId
) {
}
