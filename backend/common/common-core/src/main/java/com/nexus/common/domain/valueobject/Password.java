package com.nexus.common.domain.valueobject;

public final class Password {
    private final String value;

    public Password(String value) {
        policy.validate(value);
        this.value = value;
    }

    public String value(){
        return value;
    }

    @Override
    public String toString() {
        return "********";
    }

}
