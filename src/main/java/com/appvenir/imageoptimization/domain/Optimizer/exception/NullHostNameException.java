package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class NullHostNameException extends RuntimeException {
    public NullHostNameException(){
        super("A host name is required");
    }
}
