package com.example.Rabbit.Consumer;

import com.example.Rabbit.resources.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PurchaseOrderConsumer {
    @Value("${ust.rabbitmq.queue")
    String queueName;
    @Value("${ust.rabbitmq.exchange")
    String exchange;
    @Value("${ust.rabbitmq.routingkey")
    String routingkey;
    @RabbitListener(queues="ust_queue")
    public void consumeMessageFromQueue(OrderStatus p){
        System.out.println("Message received from queue : "+p);
    }
}
