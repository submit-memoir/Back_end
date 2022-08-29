package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;
import org.springframework.http.HttpStatus;

public class ConflictException extends MemoirException {

    public static final ConflictException EXCEPTION = new ConflictException("Conflict");

    protected ConflictException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }
}
