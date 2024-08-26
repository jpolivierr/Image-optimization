package com.appvenir.imageoptimization.domain.Optimizer.service.processors;

public interface OptimizerProcessor {
    
    public void process();

    public void processDirectory(String dir);

    public void processFile(String file);

}
