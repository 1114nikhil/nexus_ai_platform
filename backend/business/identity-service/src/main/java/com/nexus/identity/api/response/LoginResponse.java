package com.nexus.identity.api.response;

import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.common.domain.valueobject.RefreshToken;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        long expiresIn
) {

    public static LoginResponse from(
            AccessToken access,
            RefreshToken refresh,
            long expiresIn
    ){
        return new LoginResponse(access.value(),refresh.value(),expiresIn);
    }
}
