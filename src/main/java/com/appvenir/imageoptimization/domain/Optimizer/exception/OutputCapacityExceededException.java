package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class OutputCapacityExceededException extends RuntimeException {
    public OutputCapacityExceededException(){
        super("The output folder is at capacity");
    }
}
