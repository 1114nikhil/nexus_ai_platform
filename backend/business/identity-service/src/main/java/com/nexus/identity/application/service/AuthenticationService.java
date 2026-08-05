package com.nexus.identity.application.service;

import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.common.domain.valueobject.RefreshToken;
import com.nexus.identity.api.request.LoginRequest;
import com.nexus.identity.api.response.LoginResponse;
import com.nexus.identity.application.port.in.AuthenticationUseCase;
import com.nexus.identity.application.port.in.LoadUserUseCase;
import com.nexus.identity.application.port.out.TokenProvider;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final LoadUserUseCase loadUserUseCase;

//    public LoginResponse login(User user){
//        AccessToken access = tokenProvider.generateAccessToken(user);
//        RefreshToken refresh = tokenProvider.generateRefreshToken(user);
//        return LoginResponse.from(
//                access,
//                refresh,
//                3600
//        );
//    }

    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(),request.password())
                );
        User user=loadUserUseCase.loadByEmail(request.email());
        AccessToken accessToken=tokenProvider.generateAccessToken(user);
        RefreshToken refreshToken=tokenProvider.generateRefreshToken(user);
        return new LoginResponse(
                accessToken.value(),
                refreshToken.value(),
                3600L
        );
    }
}
