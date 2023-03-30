package com.amarkosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarkosh.Repository.OrderItemRepo;
import com.amarkosh.Repository.OrderRepo;
import com.amarkosh.Repository.ProductRepo;
import com.amarkosh.model.Order;
import com.amarkosh.model.OrderItem;
import com.amarkosh.model.Product;

@Service
public class ShoppingService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private OrderItemRepo orderItemRepo;
	@Autowired
	private ProductRepo productRepo;
	
	//add product
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	//Order Any item
	public String orderItemMethod(OrderItem orderItem) {
		String productName=orderItem.getProduct();
		Optional<Product> productStock=productRepo.findByName(productName);
		if(productStock.isPresent()) {
			
			 return orderItemRepo.save(orderItem)+"Ordered";
			 
		}
		else {
			return "No stock available";
		}
	}
	
	//get product inventory
	public List<Product> getAllProductDetails(){
		List<Product> listOfProducts=productRepo.findAll();
		return listOfProducts;
	}
	//get all orders
	public List<Order> getAllOrders(){
		List<Order> listOfAllOrders=orderRepo.findAll();
		return listOfAllOrders;
	}
	
}
