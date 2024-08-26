package com.appvenir.imageoptimization.domain.Optimizer.service.operations;

public interface OptimizeOperation {
    
    public void execute();

    public void undo();

    public void cleanUp();
    
}
