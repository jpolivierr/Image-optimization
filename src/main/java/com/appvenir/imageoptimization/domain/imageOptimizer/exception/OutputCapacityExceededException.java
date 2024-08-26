package com.appvenir.imageoptimization.domain.imageOptimizer.exception;

public class OutputCapacityExceededException extends RuntimeException {
    public OutputCapacityExceededException(){
        super("The output folder is at capacity");
    }
}
