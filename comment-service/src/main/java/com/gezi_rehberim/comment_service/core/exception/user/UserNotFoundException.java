package com.gezi_rehberim.comment_service.core.exception.user;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class UserNotFoundException extends BaseBusinessException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
