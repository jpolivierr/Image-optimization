package com.appvenir.imageoptimization.domain.user.exception;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(){
        super("This email address is already registered.");
    }
}
