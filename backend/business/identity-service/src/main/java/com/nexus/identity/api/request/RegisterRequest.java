package com.nexus.identity.api.request;


import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    String email;
    String password;
}
