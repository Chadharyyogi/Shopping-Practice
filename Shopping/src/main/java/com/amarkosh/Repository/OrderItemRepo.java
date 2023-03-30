package com.amarkosh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amarkosh.model.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer>{

}
