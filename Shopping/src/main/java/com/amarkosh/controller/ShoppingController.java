package com.amarkosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarkosh.model.Order;
import com.amarkosh.model.OrderItem;
import com.amarkosh.model.Product;
import com.amarkosh.service.ShoppingService;

@RestController
public class ShoppingController {

	@Autowired
	private ShoppingService sservice;
	
	@PutMapping("/add")
	public ResponseEntity<Product> addProductController(@RequestBody Product product){
		return new ResponseEntity<Product>(sservice.addProduct(product),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/order")
	public ResponseEntity<String> orderItemHandler(@RequestBody OrderItem orderItem){
		return new ResponseEntity<String>(sservice.orderItemMethod(orderItem),HttpStatus.OK);
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler(){
		return new ResponseEntity<List<Product>>(sservice.getAllProductDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrdersHandler(){
		return new ResponseEntity<List<Order>>(sservice.getAllOrders(),HttpStatus.OK);
	}
	
}
