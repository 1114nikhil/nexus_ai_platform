package com.nexus.identity.application.port.in;

import com.nexus.identity.api.request.LoginRequest;
import com.nexus.identity.api.response.LoginResponse;

public interface AuthenticationUseCase {
    LoginResponse login(LoginRequest request);
}
