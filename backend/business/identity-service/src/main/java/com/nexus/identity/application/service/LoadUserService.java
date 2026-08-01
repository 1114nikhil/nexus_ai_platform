package com.nexus.identity.application.service;

import com.nexus.identity.application.port.in.LoadUserUseCase;
import com.nexus.identity.application.port.out.UserRepositoryPort;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadUserService implements LoadUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User loadByEmail(String email) {
        return userRepositoryPort.findByEmail(email).orElseThrow(()-> new IllegalArgumentException("User not Found"));
    }
}
