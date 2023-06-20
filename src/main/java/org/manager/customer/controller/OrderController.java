package org.manager.customer.controller;

import java.util.List;

import org.manager.customer.controller.model.Orders;
import org.manager.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Orders>> get(@PathVariable Integer id) {
		return new ResponseEntity<>(orderService.getAllOrderForCustomer(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Orders> add(@RequestBody Orders product) {
		System.out.println("Added " + product.toString());
		return new ResponseEntity<>(orderService.add(product) , HttpStatus.OK);
	}
}
