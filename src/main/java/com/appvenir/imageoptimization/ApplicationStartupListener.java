package com.appvenir.imageoptimization;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApplicationStartupListener {

    private final ImageOptimizationConsumer imageOptimizationConsumer;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent()
    {
        // try {
        //     imageOptimizationConsumer.listen();
        // } catch (IOException | TimeoutException e) {
        //     logger.error(e.getMessage(), e);
        // }
    }

    
}
