package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.model.AuthenticatedUser;
import com.nexus.common.domain.valueobject.AccessToken;
import com.nexus.identity.application.port.out.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;



    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(header==null||!header.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String jwt = header.substring(7);

        AccessToken accessToken = new AccessToken(jwt);

        if(!tokenProvider.validate(accessToken)){
            filterChain.doFilter(request,response);
            return;
        }

        AuthenticatedUser authenticatedUser=tokenProvider.authenticate(accessToken);

//        JwtPrincipal jwtPrincipal = new JwtPrincipal(authenticatedUser);

        UsernamePasswordAuthenticationToken authentication =new UsernamePasswordAuthenticationToken(authenticatedUser,null,authenticatedUser.roles()
                                .stream()
                                .map(role -> new SimpleGrantedAuthority(role.name()))
                                .collect(Collectors.toSet()));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request,response);
    }
}
