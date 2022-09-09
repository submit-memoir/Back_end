package com.memoir.submit.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class MemoirExceptionHandler {

    // TODO Exception이 올 때 com.memoir.submit.exception.handler.errorresponse@551743b6 이런식으로 오는 이유 알아보기

    @ExceptionHandler(MemoirException.class)
    protected ResponseEntity<ErrorResponse> handleMemoirException(final MemoirException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getStatus(), e.getMessage()), HttpStatus.valueOf(e.getStatus()));
    }

}
