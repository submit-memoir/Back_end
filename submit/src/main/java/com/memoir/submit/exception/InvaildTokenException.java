package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;

public class InvaildTokenException extends MemoirException {

    public static final InvaildTokenException EXCEPTION = new InvaildTokenException();

    private InvaildTokenException() {
        super(401, "Token is invaild");
    }
}
