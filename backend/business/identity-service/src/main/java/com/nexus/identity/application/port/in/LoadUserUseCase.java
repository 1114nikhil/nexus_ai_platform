package com.nexus.identity.application.port.in;

import com.nexus.identity.domain.model.User;

public interface LoadUserUseCase {
    User loadByEmail(String email);
}
