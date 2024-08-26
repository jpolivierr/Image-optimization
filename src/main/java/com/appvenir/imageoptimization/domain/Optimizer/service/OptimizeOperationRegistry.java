package com.appvenir.imageoptimization.domain.Optimizer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import com.appvenir.imageoptimization.domain.Optimizer.enums.OperationType;
import com.appvenir.imageoptimization.domain.Optimizer.model.OptimizationContext;
import com.appvenir.imageoptimization.domain.Optimizer.service.operations.OptimizeOperation;

public class OptimizeOperationRegistry {

    private final Map<OperationType, BiFunction<String, OptimizationContext, OptimizeOperation>> registry = new HashMap<>();

    public void register(OperationType operationType, BiFunction<String, OptimizationContext, OptimizeOperation> operation) {
        registry.put(operationType, operation);
    }

    public OptimizeOperation getOperation(OperationType operationType, String filePath, OptimizationContext context) {
        if (!registry.containsKey(operationType)) {
            throw new UnsupportedOperationException("No operation registered with name: " + operationType);
        }
        return registry.get(operationType).apply(filePath, context);
    }
}
