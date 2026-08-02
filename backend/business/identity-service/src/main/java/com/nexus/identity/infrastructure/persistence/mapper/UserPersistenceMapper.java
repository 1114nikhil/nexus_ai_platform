package com.nexus.identity.infrastructure.persistence.mapper;

import com.nexus.common.domain.valueobject.Email;
import com.nexus.common.domain.valueobject.Password;
import com.nexus.identity.domain.model.User;
import com.nexus.identity.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserPersistenceMapper {

    public UserEntity toEntity(User user){
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setPassword(user.getPassword().value());
        entity.setEmail(user.getEmail().value());
        entity.setActive(user.isActive());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setAccountNonExpired(user.isAccountNonExpired());
        entity.setAccountNonLocked(user.isAccountNonLocked());
        entity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        entity.setEnabled(user.isEnabled());
        return entity;
    }

//    public User toDomain(UserEntity entity){
//        return new User(
//                entity.getId(),
//                entity.getFirstName(),
//                entity.getLastName(),
//                new Email(entity.getEmail()),
//                entity.getPassword(),
//                entity.isActive(),
//                entity.getCreatedAt()
//        );
//    }

    public User toDomain(UserEntity entity) {
        return User.restore(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                new Email(entity.getEmail()),
                new Password(entity.getPassword()),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.isAccountNonExpired(),
                entity.isAccountNonLocked(),
                entity.isCredentialsNonExpired(),
                entity.isEnabled(),
                new HashSet<>()
        );
    }
}
