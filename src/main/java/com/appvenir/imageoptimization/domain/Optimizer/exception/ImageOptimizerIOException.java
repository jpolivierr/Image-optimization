package com.appvenir.imageoptimization.domain.Optimizer.exception;

public class ImageOptimizerIOException extends RuntimeException{
    
    public ImageOptimizerIOException(Exception ex){
        super(ex.getMessage());
    }

}
