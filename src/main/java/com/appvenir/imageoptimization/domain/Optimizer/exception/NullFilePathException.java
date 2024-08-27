package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class NullFilePathException extends RuntimeException{
    public NullFilePathException(){
        super("The file path cannot be null.");
    }
}
