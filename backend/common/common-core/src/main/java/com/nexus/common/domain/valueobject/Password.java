package com.nexus.common.domain.valueobject;
import com.nexus.common.domain.service.PasswordPolicy;

public final class Password {
    private final String value;

    public Password raw(String value,PasswordPolicy policy) {
        policy.validate(value);
        return new Password(value);
    }
    private Password(String value) {
        this.value = value;
    }
    public static Password encoded(String encodedPassword){
        return new Password(encodedPassword);
    }

    public String value(){
        return value;
    }

    @Override
    public String toString() {
        return "********";
    }

}
