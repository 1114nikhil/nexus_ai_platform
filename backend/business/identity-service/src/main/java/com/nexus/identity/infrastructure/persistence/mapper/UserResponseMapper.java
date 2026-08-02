package com.nexus.identity.infrastructure.persistence.mapper;

import com.nexus.identity.api.response.UserResponse;
import com.nexus.identity.domain.model.User;

import java.util.Locale;

public class UserResponseMapper {
    public UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail().value()
        );
    }
}
