package com.appvenir.imageoptimization.domain.Optimizer.service.attributes;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ScaleAttribute {
    private final Integer width;
    private final Integer height;
    private final Integer sizeIncrease;
    private final Integer sizeDecrease;
}
