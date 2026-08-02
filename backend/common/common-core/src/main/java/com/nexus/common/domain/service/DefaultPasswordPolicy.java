package com.nexus.common.domain.service;

import com.nexus.common.domain.exception.PasswordPolicyException;

import java.util.regex.Pattern;

public class DefaultPasswordPolicy implements PasswordPolicy{
    private static final int MIN_LENGTH=6;
    private static final int MAX_LENGTH=128;

    /*
     * At least:
     * 1 uppercase
     * 1 lowercase
     * 1 digit
     * 1 special character
     * No whitespace
     */
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(
                    "^(?=.*[a-z])" +
                            "(?=.*[A-Z])" +
                            "(?=.*\\d)" +
                            "(?=.*[@$!%*?&()_+\\-=#^~{}\\[\\]:;<>,./])" +
                            "(?!.*\\s)" +
                            ".+$"
            );
    @Override
    public void validate(String password) {
        if(password==null||password.isBlank()){
            throw new PasswordPolicyException("Password is required !");
        }

        password= password.trim();

        if(password.length()<MIN_LENGTH){
            throw new PasswordPolicyException("Password must contain at least "+MIN_LENGTH+" character !");
        }
        if(password.length()>MAX_LENGTH){
            throw new PasswordPolicyException("Password cannot exceed  "+MIN_LENGTH+" character !");
        }
        if(!PASSWORD_PATTERN.matcher(password).matches()){
            throw new PasswordPolicyException(
                    "Password must contain uppercase, lowercase, number, and special character."
            );
        }

    }
}
