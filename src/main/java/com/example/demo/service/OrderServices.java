package com.example.demo.service;

import com.example.demo.entity.OrderServiceEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.OrderService;
import com.example.demo.repository.OrderServiceRepository;
import com.example.demo.translator.OrderServiceTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServices {

    @Autowired
    private OrderServiceRepository repository;

    public OrderService createService(OrderService orderService){
        OrderServiceEntity entity= OrderServiceTranslator.toEntity(orderService);
        OrderServiceEntity entity1= repository.save(entity);
       return OrderServiceTranslator.toDomain(entity1);
    }

    public List<OrderService> getServices(int id){
        return repository.findByOrderId(id)
                .map(OrderServiceTranslator:: toDomain)
                .collect(Collectors.toList());
    }

    public OrderService updateService(OrderService orderService){
    	if(repository.existsByOrderId(orderService.getOrderId())) {
    		throw new ResourceNotFoundException("MISSING_ORDER; order id = " + orderService.getOrderId());
    	}
    	
    	List<OrderService> orderServiceList= getServices(orderService.getOrderId);
    	OrderService orderService2= orderServiceList.get(0);
    	OrderServiceEntity entity=OrderServiceTranslator.toEntity(orderService2);
    	return OrderServiceTranslator.toDomain(repository.save(entity));
    	
    }
}
