package com.appvenir.imageoptimization.domain.imageOptimizer.exception;

public class NoOptimizationOperationSpecifyException extends RuntimeException {

    public NoOptimizationOperationSpecifyException(){
        super("No optimization operations specified");
    }
    
}
