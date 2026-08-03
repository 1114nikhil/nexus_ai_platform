package com.nexus.identity.api.request;

public record LoginRequest(
        String email,
        String password
) {
}
