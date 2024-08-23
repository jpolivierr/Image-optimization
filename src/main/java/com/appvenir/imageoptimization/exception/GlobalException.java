package com.appvenir.imageoptimization.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.appvenir.imageoptimization.domain.user.exception.EmailAlreadyExistException;
import com.appvenir.imageoptimization.http.ResponseFailure;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalException {

    @Value("${app.environment}")
    private String environment;

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<?> handleEmailAlreadyExistException(
        EmailAlreadyExistException ex, 
        HttpServletRequest request){

            ResponseFailure response = ResponseFailure.builder(ex)
                                            .setMessage(ex.getMessage())
                                            .build(environment);

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(
        Exception ex, 
        HttpServletRequest request){

            ResponseFailure response = ResponseFailure.builder(ex)
                                            .setMessage(ex.getMessage())
                                            .build(environment);

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    
}
