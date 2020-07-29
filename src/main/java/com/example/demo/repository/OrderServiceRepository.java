package com.example.demo.repository;

import com.example.demo.entity.OrderServiceEntity;
import java.util.List;

public class OrderServiceRepository extends CrudRepository<OrderServiceEntity,Integer> {
    List<OrderServiceEntity> findAll();
    OrderServiceEntity findByOrderId(Integer id);
    boolean existsByOrderId(Integer id);
}
