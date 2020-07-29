package com.example.demo.translator;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.example.demo.entity.OrderServiceEntity;
import com.example.demo.model.OrderService;

public class OrderServiceTranslator {
	
	public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
    public static OrderServiceEntity toEntity(OrderService orderService){
        if(orderService == null){
            return null;
        }
        OrderServiceEntity entity= new OrderServiceEntity();
        entity.setOrderId(orderService.getOrderId());
        entity.setCustomerName(orderService.getCustomerName());
        entity.setOrderDate(ZonedDateTime.ofInstant(Instant.parse(orderService.getOrderDate(), ZoneOffset.systemDefault())));
        entity.setShippingAddress(orderService.getShippingAddress());
        entity.setTotal(orderService.getTotal());
        entity.setOrderItem(OrderItemTranslator.toEntity(orderService.getOrderItemList));
        return entity;
    }

    public static OrderService toDomain(OrderServiceEntity entity){
        if(entity == null){
            return null;
        }
        OrderService service= new OrderService();
        service.setCustomerName(entity.getCustomerName());
        ZonedDateTime zonedDateTime = entity.getOrderDate().atStartOfDay(ZoneId.systemDefault());
		ZonedDateTime utcDateTime = ZonedDateTime.ofInstant(zonedDateTime.toInstant(), ZoneOffset.UTC);
		
        service.setOrderDate(DateTimeFormatter.ofPattern(ISO_DATE_TIME_FORMAT).format(utcDateTime));
        service.setOrderId(entity.getOrderId());
        service.setOrderItem(OrderItemTranslator.toDomain(entity.getOrderItemList()));
        service.setShippingAddress(entity.getShippingAddress());
        service.setTotal(entity.getTotal());
        return service;
    }
}
