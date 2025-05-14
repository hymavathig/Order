package com.Order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Order.model.Order;
import com.Order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService service;
	
	@PostMapping()
	public Order addOrder(@RequestBody Order o) {
		return service.saveOrder(o);
	}
	
	@GetMapping()
		public List<Order> getOrder(){
			return service.getOrders();
		}
	
	@GetMapping("/{id}")
	public Order getAllOrders(@PathVariable Long id) {
		return service.getOrderbyId(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}
	
	@PutMapping("/{id}")
	public Order updateOrders(@PathVariable Long id, @RequestBody Order newOrder) {
		return service.updateOrder(id, newOrder);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrder(@PathVariable Long id) {
		service.deleteOrder(id);
		return "Deletion successfully";
		
	}
	

}
