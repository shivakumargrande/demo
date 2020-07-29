package com.example.demo.client;

import com.example.demo.model.OrderItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value="/orderItemClient")
public interface OrderItemClient {

    @PostMapping
    public OrderItemClient createOrderItem(OrderItem orderItem);

    @GetMapping
    public List<OrderItemClient> getOrderItem(@PathVariable("id") Long orderId);
}
