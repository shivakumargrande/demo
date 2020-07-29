package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.OrderItemEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.translator.OrderItemTranslator;

public class OrderItemService {
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	public OrderItem createOrderItem(OrderItem orderItem) {
		if(orderItem.existsByProductId(orderItem.getProductId())) {
			throw new ResourceNotFoundException("MISSING_ORDER_ITEM; product id = " + orderItem.getProductId());
		}
		OrderItemEntity entity= OrderItemTranslator.toEntity(orderItem);
		OrderItemEntity entity2=orderItemRepository.save(entity);
		return OrderItemTranslator.toDomain(entity2);
	}
	
	public List<OrderItem> getItemsByProductId(int productId){
		return orderItemRepository.findByProductId(productId)
				.map(OrderItemTranslator::toDomain)
				.collect(Collectors.toList());
	}
	
	public List<OrderItem> getItems(){
		return orderItemRepository.findAll()
				.map(OrderItemTranslator::toDomain)
				.collect(Collectors.toList());
			
	}
}
