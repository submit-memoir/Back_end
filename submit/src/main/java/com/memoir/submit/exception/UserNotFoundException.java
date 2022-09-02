package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;

public class UserNotFoundException extends MemoirException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(404, "User not found");
    }
}
