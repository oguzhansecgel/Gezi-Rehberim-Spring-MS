package com.gezi_rehberim.user_service.core.exception.user;

import org.springframework.security.authentication.BadCredentialsException;

public class WrongUserNameOrPasswordException extends BadCredentialsException {
    public WrongUserNameOrPasswordException(String message) {
        super(message);
    }
}
