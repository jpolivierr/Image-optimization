package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class NoOptimizationOperationSpecifyException extends RuntimeException {

    public NoOptimizationOperationSpecifyException(){
        super("No optimization operations specified");
    }
    
}
