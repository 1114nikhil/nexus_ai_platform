package com.nexus.identity.application.port.in;

import com.nexus.identity.api.request.RegisterRequest;
import com.nexus.identity.api.response.UserResponse;

public interface RegisterUserUseCase {
    UserResponse register(RegisterRequest request);
}
