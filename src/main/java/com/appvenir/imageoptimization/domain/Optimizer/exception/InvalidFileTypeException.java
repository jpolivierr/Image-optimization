package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class InvalidFileTypeException extends RuntimeException {

    public InvalidFileTypeException(){
        super("Invalid file type. Only jpg, jpeg, and png are allowed.");
    }

    public InvalidFileTypeException(String message){
        super(message);
    }
    
}
