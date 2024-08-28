package com.appvenir.imageoptimization.domain.Optimizer.service.operations;

public interface ImageOperation {
    
    public void execute();

    public void undo();

    public void cleanUp();
    
}
