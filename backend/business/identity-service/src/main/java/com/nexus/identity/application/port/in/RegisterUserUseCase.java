package com.nexus.identity.application.port.in;

import com.nexus.identity.api.request.RegisterRequest;
import com.nexus.identity.api.response.UserResponse;
import com.nexus.identity.domain.model.User;

public interface RegisterUserUseCase {
    User register(RegisterRequest request);
}
