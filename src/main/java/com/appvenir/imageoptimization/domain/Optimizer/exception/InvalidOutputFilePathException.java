package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class InvalidOutputFilePathException extends RuntimeException {

    public InvalidOutputFilePathException(){
        super("The output path is not a directory");
    }
    
}
