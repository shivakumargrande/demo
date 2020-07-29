package com.example.demo.repository;

import com.example.demo.entity.OrderItemEntity;
import com.example.demo.entity.OrderServiceEntity;

public class OrderItemRepository extends CrudRepository<OrderItemEntity,Integer>{
	List<OrderItemEntity> findAll();
	List<OrderItemEntity> findByProductId(int productId);
	 boolean existsByProductId(Integer id);
}
