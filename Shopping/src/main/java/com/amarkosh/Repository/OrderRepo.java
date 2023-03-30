package com.amarkosh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amarkosh.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
