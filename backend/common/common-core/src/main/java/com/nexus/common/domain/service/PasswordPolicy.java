package com.nexus.common.domain.service;

public interface PasswordPolicy {
    void validate(String password);
}
