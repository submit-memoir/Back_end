package com.memoir.submit.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    protected ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
