package com.nexus.identity.application.service;

import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.common.domain.valueobject.RefreshToken;
import com.nexus.identity.api.response.LoginResponse;
import com.nexus.identity.application.port.out.TokenProvider;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenProvider tokenProvider;

    public LoginResponse login(User user){
        AccessToken access = tokenProvider.generateAccessToken(user);
        RefreshToken refresh = tokenProvider.generateRefreshToken(user);
        return LoginResponse.from(
                access,
                refresh,
                3600
        );
    }
}
