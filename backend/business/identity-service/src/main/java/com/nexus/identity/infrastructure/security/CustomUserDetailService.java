package com.nexus.identity.infrastructure.security;

import com.nexus.identity.application.port.in.LoadUserUseCase;
import com.nexus.identity.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final LoadUserUseCase loadUserUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = loadUserUseCase.loadByEmail(username);
        return new SecurityUser(user);
    }
}
