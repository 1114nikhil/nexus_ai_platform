package com.nexus.common.domain.valueobject;

import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {
    private static final Pattern EMAIL_PATTERN=Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private final String value;

    public Email(String value) {
        if(value==null||value.isBlank()){
            throw new IllegalArgumentException("Email cannot be empty!");
        }
        if(!EMAIL_PATTERN.matcher(value).matches()){
            throw new IllegalArgumentException("Invalid Email!");
        }
        this.value = value.toLowerCase().trim();
    }

    public String value(){
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
