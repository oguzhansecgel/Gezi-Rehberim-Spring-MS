package com.gezi_rehberim.favorite_place_service.core.exception.user;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class UserNotFoundException extends BaseBusinessException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
