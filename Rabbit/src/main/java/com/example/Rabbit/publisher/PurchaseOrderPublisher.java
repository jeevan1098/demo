package com.example.Rabbit.publisher;

import com.example.Rabbit.resources.OrderStatus;
import com.example.Rabbit.resources.PurchaseOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
    @Autowired
    private RabbitTemplate template;
    @Value("${ust.rabbitmq.queue")
    String queueName;
    @Value("${ust.rabbitmq.exchange")
    String exchange;
    @Value("${ust.rabbitmq.routingkey")
    String routingkey;
    @PostMapping("/{customerName}")
    public String bookOrder(PurchaseOrder order, String customerName){
        order.setOrderId(customerName);
        OrderStatus orderStatus = new OrderStatus(order, "process", "order placed successfully "+customerName);
        template.convertAndSend(exchange,routingkey,order);
        return "Success !!";
    }
}
//bnbm
