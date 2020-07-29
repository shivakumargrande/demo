package com.example.demo.controller;

import com.example.demo.model.OrderService;
import com.example.demo.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/orderService")
public class OrderServiceController {

    @Autowired
    private OrderServices orderServices;
    @PostMapping
    public OrderService createOrderService(OrderService orderService){
        return orderServices.createService(orderService);
    }

    @PutMapping
    public OrderService updateOrderService(OrderService orderService){
        return orderServices.updateService(orderService);
    }

    @GetMapping
    public List<OrderService> getOrderService(@PathVariable("id") Long orderId){
        return orderServices.getServices(orderId);
    }
}
