package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data(name="OrderItem")
public class OrderItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
    private int productId;
	
	
    private int orderId;
    private String productCode;
    private String productName;
    private int quantity;

}
