package com.nexus.identity.api.controller;

import com.nexus.identity.api.request.RegisterRequest;
import com.nexus.identity.api.response.UserResponse;
import com.nexus.identity.application.port.in.RegisterUserUseCase;
import com.nexus.identity.domain.model.User;
import com.nexus.identity.infrastructure.persistence.mapper.UserResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;

    private final UserResponseMapper userResponseMapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@Valid @RequestBody RegisterRequest request){
        User user = registerUserUseCase.register(request);
        return userResponseMapper.toResponse(user);
    }
}
