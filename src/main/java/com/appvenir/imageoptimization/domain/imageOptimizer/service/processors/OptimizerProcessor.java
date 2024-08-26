package com.appvenir.imageoptimization.domain.imageOptimizer.service.processors;

public interface OptimizerProcessor {
    
    public void process();

    public void processDirectory(String dir);

    public void processFile(String file);

}
