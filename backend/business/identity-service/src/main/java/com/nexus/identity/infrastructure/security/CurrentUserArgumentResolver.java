package com.nexus.identity.infrastructure.security;

import com.nexus.common.domain.model.AuthenticatedUser;
import com.nexus.common.domain.model.Role;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.stream.Collectors;

public class CurrentUserArgumentResolver
        implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(AuthenticatedUser.class);

    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            @Nullable ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            @Nullable WebDataBinderFactory binderFactory
    ) {

        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if (authentication == null) {
            return null;
        }

        return authentication.getPrincipal();
    }
}
