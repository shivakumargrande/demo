package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderService {
    private int orderId;
    private String customerName;
    private String orderDate;
    private String shippingAddress;
    private String orderItems;
    private String total;
    private List<OrderItem> orderItemList;

}
