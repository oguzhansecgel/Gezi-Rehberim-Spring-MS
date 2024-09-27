package com.gezi_rehberim.comment_service.core.exception.comment;

import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

public class CommentNotFoundException extends BaseBusinessException {
    public CommentNotFoundException(String message) {
        super(message);
    }
}
