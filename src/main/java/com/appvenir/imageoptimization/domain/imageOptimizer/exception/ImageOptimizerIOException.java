package com.appvenir.imageoptimization.domain.imageOptimizer.exception;

public class ImageOptimizerIOException extends RuntimeException{
    
    public ImageOptimizerIOException(Exception ex){
        super(ex.getMessage());
    }

}
