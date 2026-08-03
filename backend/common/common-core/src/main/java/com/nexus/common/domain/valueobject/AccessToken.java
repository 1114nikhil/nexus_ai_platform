package com.nexus.common.domain.valueobject;

import java.util.Objects;

public final class AccessToken {
    private final String value;


    public AccessToken(String value) {
        if(value==null||value.isBlank()){
            throw new IllegalArgumentException("Access token cannot be null !");
        }
        this.value = value;
    }

    public String value(){
        return value;
    }

    @Override
    public String toString() {
        return "*******";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof AccessToken accessToken)){
            return false;
        }

        return Objects.equals(value,accessToken.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
