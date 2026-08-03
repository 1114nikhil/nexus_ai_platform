package com.nexus.common.domain.valueobject;

import java.util.Objects;

public final class RefreshToken {
    private final String value;

    public RefreshToken(String value) {
        if(value==null||value.isBlank()){
            throw new IllegalArgumentException("Refresh Token cannot be empty !");
        }
        this.value = value;
    }
    public String value(){
        return value;
    }

    @Override
    public String toString() {
        return "******";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(this ==obj)
            return true;

        if(!(obj instanceof RefreshToken refreshToken))
            return false;
        return Objects.equals(value,refreshToken.value);
    }
}
