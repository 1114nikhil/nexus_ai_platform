package com.nexus.identity.application.port.out;

import com.nexus.identity.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
}
