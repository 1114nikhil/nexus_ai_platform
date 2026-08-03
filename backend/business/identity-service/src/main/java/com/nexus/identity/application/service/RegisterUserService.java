package com.nexus.identity.application.service;

import com.nexus.common.domain.valueobject.Email;
import com.nexus.common.domain.valueobject.Password;
import com.nexus.identity.api.request.RegisterRequest;
import com.nexus.identity.application.port.in.RegisterUserUseCase;
import com.nexus.identity.application.port.out.UserRepositoryPort;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepositoryPort repositoryPort;

    private final PasswordEncoder passwordEncoderConfig;

    @Override
    public User register(RegisterRequest request) {
        Email email= new Email(request.email());
        Password encoderPassword = Password.encoded(passwordEncoderConfig.encode(request.password()));
        User user = User.register(
                request.firstName(),
                request.lastName(),
                email,
                encoderPassword
        );
        return repositoryPort.save(user);
    }
}
