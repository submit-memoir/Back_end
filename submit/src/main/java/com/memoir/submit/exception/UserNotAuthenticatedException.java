package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;

public class UserNotAuthenticatedException extends MemoirException {

    public static final UserNotAuthenticatedException EXCEPTION = new UserNotAuthenticatedException();

    private UserNotAuthenticatedException() {
        super(401, "User is not Authenticated.");
    }
}
