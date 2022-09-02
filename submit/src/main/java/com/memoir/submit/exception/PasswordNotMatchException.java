package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;

public class PasswordNotMatchException extends MemoirException {

    public static final PasswordNotMatchException EXCEPTION = new PasswordNotMatchException();

    private PasswordNotMatchException() {
        super(400 , "Password not matched");
    }
}
