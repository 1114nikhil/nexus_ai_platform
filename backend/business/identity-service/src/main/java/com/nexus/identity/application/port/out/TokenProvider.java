package com.nexus.identity.application.port.out;

import com.nexus.common.domain.model.AuthenticatedUser;
import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.common.domain.valueobject.Email;
import com.nexus.common.domain.valueobject.RefreshToken;
import com.nexus.identity.domain.model.User;
import com.nexus.identity.infrastructure.security.JwtClaims;

public interface TokenProvider {
    AccessToken generateAccessToken(User user);
    RefreshToken generateRefreshToken(User user);
    boolean validate(AccessToken token);
    AuthenticatedUser authenticate(AccessToken token);
}
