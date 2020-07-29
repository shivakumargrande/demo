package com.example.demo.translator;

import com.example.demo.entity.OrderItemEntity;
import com.example.demo.model.OrderItem;

public class OrderItemTranslator {
    public static OrderItemEntity toEntity(OrderItem orderItem){
        if(orderItem == null){
            return null;
        }
        OrderItemEntity entity= new OrderItemEntity();
        entity.setOrderId(orderItem.getOrderId());
        entity.setProductCode(orderItem.getProductCode());
        entity.setProductName(orderItem.getProductName());
        entity.setOrderId(orderItem.getOrderId());
        entity.setQuantity(orderItem.getQuantity());
        return  entity;
    }
    
    public static OrderItem toDomain(OrderItemEntity entity) {
    	if(entity == null) {
    		return null;
    	}
    	
    	OrderItem item= new OrderItem();
    	item.setOrderId(entity.getOrderId());
    	item.setProductCode(entity.getProductCode());
    	item.setProductName(entity.getProductName());
    	item.setOrderId(entity.getOrderId());
    	item.setQuanity(entity.getQuantity());
    	return item;
    }
}
