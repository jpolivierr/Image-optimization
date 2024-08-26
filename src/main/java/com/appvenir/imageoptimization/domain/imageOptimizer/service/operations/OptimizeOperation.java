package com.appvenir.imageoptimization.domain.imageOptimizer.service.operations;

public interface OptimizeOperation {
    
    public void execute();

    public void undo();

    public void cleanUp();
    
}
