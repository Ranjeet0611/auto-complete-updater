package com.autocompleteupdater.exception.advice;

import com.autocompleteupdater.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {IllegalAccessException.class})
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalAccessException e, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder()
                .setErrorMessage(e.getMessage()).
                setStatus(HttpStatus.BAD_REQUEST.name())
                .setTime()
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
