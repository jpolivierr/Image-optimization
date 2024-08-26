package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class NullTargetPathException extends RuntimeException{
    public NullTargetPathException(){
        super("Target path cannot be null");
    }
}
