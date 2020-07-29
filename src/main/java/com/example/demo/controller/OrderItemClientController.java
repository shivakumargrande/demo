package com.example.demo.controller;

import com.example.demo.client.OrderItemClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/orderItem")
public class OrderItemClientController {

    @PostMapping
    public OrderItemClient createOrderItem(OrderItemClient orderItemClient){

        return null;
    }

    @GetMapping
    public List<OrderItemClient> getOrderItem(@PathVariable("id") Long orderId){
        return null;
    }
}
