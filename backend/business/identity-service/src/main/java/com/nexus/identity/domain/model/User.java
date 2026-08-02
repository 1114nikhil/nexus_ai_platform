package com.nexus.identity.domain.model;

import com.nexus.common.domain.valueobject.Email;
import com.nexus.common.domain.valueobject.Password;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;
    private Password password;
    private boolean active;
    private LocalDateTime createdAt;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked= true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private Set<Roles> roles;

    /**
     * Factory method for new user registration.
     */
    public static User register(
            String firstName,
            String lastName,
            Email email,
            Password encodedPassword
    ) {

        User user = new User();

        user.id = UUID.randomUUID();
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = encodedPassword;

        user.active = true;
        user.createdAt = LocalDateTime.now();

        user.accountNonExpired = true;
        user.accountNonLocked = true;
        user.credentialsNonExpired = true;
        user.enabled = true;

        return user;
    }

    /**
     * Factory method used only when loading data from the database.
     */
    public static User restore(
            UUID id,
            String firstName,
            String lastName,
            Email email,
            Password password,
            boolean active,
            LocalDateTime createdAt,
            boolean accountNonExpired,
            boolean accountNonLocked,
            boolean credentialsNonExpired,
            boolean enabled,
            Set<Roles> roles
    ) {

        User user = new User();

        user.id = id;
        user.firstName = firstName;
        user.lastName = lastName;
        user.email = email;
        user.password = password;

        user.active = active;
        user.createdAt = createdAt;

        user.accountNonExpired = accountNonExpired;
        user.accountNonLocked = accountNonLocked;
        user.credentialsNonExpired = credentialsNonExpired;
        user.enabled = enabled;

        if (roles != null) {
            user.roles = roles;
        }

        return user;
    }
}
