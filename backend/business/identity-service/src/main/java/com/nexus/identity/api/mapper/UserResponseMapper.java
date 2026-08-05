package com.nexus.identity.api.mapper;

import com.nexus.identity.api.response.UserResponse;
import com.nexus.identity.domain.model.User;
import org.springframework.stereotype.Component;

@Component
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
