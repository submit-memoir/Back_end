package com.memoir.submit.exception.handler;

import lombok.Getter;

@Getter
public class MemoirException extends RuntimeException {

    private final int status;
    private final String message;

    protected MemoirException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
