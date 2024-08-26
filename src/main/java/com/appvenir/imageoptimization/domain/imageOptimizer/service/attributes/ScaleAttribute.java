package com.appvenir.imageoptimization.domain.imageOptimizer.service.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ScaleAttribute {
    private final Double width;
    private final Double height;
    private final Double sizeIncrease;
    private final Double sizeDecrease;
}
