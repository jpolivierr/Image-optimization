package com.appvenir.imageoptimization.domain.Optimizer.exception;

import com.appvenir.imageoptimization.domain.Optimizer.enums.OperationType;

public class UnsupportedOperationException extends RuntimeException{
    
    public UnsupportedOperationException(OperationType operationType){
        super("No operation registered with name: " + operationType);
    }

}
