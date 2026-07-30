package com.nexus.identity.infrastructure.persistence.mapper;

import com.nexus.identity.domain.model.User;
import com.nexus.identity.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    public UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setActive(user.isActive());
        entity.setCreatedAt(user.getCreatedAt());
        return entity;
    }

    public User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.isActive(),
                entity.getCreatedAt()
        );
    }
}
