package com.example.demo.model;

import lombok.Data;

@Data
public class OrderItem {
    private int orderId;
    private int productId;
    private String productCode;
    private String productName;
    private int quantity;

}
