package com.Order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Order.model.Order;
import com.Order.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;
	
	public Order saveOrder(Order o) {
		return repo.save(o);
	}
	
	public List<Order> getOrders(){
		return repo.findAll();
	}
	
	public Optional<Order> getOrderbyId(Long id){
		return repo.findById(id);
	}
	
	public Order updateOrder(Long id, Order newOrder) {
		return repo.findById(id).map(order -> {
			order.setName(newOrder.getName());
			order.setQuantity(newOrder.getQuantity());
			order.setPrice(newOrder.getPrice());
			return repo.save(order);
		}).orElseThrow(() -> new RuntimeException("Order not found"));
	}
	
	public void deleteOrder(Long id) {
		repo.deleteById(id);
	}
}
