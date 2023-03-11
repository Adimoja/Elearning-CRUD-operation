package com.elearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.TimeZone;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundException(StudentNotFoundException e){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,
                e.getMessage(),
                TimeZone.getTimeZone("Z"));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
