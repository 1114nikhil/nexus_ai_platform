package com.nexus.identity.application.service;

import com.nexus.identity.api.request.RegisterRequest;
import com.nexus.identity.api.response.UserResponse;
import com.nexus.identity.application.port.in.RegisterUserUseCase;
import com.nexus.identity.application.port.out.UserRepositoryPort;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepositoryPort repositoryPort;

    @Override
    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .firstName(request.firstName)
                .lastName(request.lastName)
                .email(request.email)
                .active(true)
                .createdAt(LocalDateTime.now())
                .password(request.password)
                .build();
        User saved = repositoryPort.save(user);
        
        return new UserResponse(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail()
        );
    }
}
