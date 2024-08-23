package com.appvenir.imageoptimization.domain.user.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("User was not found");
    }
    
}
