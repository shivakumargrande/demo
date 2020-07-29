package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data(name="OrderService")
public class OrderServiceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private OrderItemEntity orderItem;
    
    @Column(name = "customerName")
    private String customerName;
    
    @Column(name = "orderDate")
    private ZonedDateTime orderDate;
    
    @Column(name = "shippingAddress")
    private String shippingAddress;
    
    @Column(name = "total")
    private String total;
}
