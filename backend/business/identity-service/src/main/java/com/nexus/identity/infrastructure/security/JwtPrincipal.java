package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.model.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtPrincipal implements Principal {

    private final AuthenticatedUser authenticatedUser;

    @Override
    public String getName() {
        return authenticatedUser.email().value();
    }

    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authenticatedUser.roles().stream().map(role->new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
    }

}
