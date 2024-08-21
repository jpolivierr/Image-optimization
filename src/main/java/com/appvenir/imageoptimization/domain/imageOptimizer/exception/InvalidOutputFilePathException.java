package com.appvenir.imageoptimization.domain.imageOptimizer.exception;

public class InvalidOutputFilePathException extends RuntimeException {

    public InvalidOutputFilePathException(){
        super("The output path is not a directory");
    }
    
}
