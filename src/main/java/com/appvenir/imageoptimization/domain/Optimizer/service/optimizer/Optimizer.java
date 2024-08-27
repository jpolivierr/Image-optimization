package com.appvenir.imageoptimization.domain.Optimizer.service.optimizer;

import java.util.Set;

import com.appvenir.imageoptimization.domain.Optimizer.service.operations.OptimizeOperation;

public interface Optimizer {
    public void run();

    public Set<OptimizeOperation> getOptimizeOperations();
}
