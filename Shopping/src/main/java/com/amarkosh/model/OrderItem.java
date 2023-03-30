package com.amarkosh.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderItem  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String product;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
}
