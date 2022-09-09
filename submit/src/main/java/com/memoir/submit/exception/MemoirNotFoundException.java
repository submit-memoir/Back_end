package com.memoir.submit.exception;

import com.memoir.submit.exception.handler.MemoirException;

public class MemoirNotFoundException extends MemoirException {

    public static final MemoirNotFoundException EXCEPTION = new MemoirNotFoundException();

    private MemoirNotFoundException() {
        super(404, "Memoir not found");
    }
}
