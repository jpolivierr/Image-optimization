package com.appvenir.imageoptimization;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class ImageOptimizationConsumer {

    private final String HOST = "localhost";
    // private final String EXCHANCE_TYPE= "direct-exchange";
    private final String QUEUE_NAME = "optimizer";
    private static final Logger logger = LoggerFactory.getLogger(ImageOptimizationConsumer.class);

    public void listen() throws IOException, TimeoutException
    {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        logger.info("Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            logger.info("Received :" + message);
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { } );

    }
    
}
