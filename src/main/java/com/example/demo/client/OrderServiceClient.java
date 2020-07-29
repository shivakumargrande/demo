package com.example.demo.client;

import com.example.demo.model.OrderService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value="/orderServiceClient")
public interface OrderServiceClient {

    @PostMapping
    public OrderItemClient createOrderService(OrderService orderItemClient);

    @GetMapping
    public List<OrderItemClient> getOrderService(@PathVariable("id") Long orderId);

}
