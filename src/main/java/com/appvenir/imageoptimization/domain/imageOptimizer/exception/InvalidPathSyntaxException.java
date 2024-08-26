package com.appvenir.imageoptimization.domain.imageOptimizer.exception;

public class InvalidPathSyntaxException extends RuntimeException{
    
    public InvalidPathSyntaxException(String path){
        super("Invalid path syntax: " + path);
    }

}
