package org.manager.customer.controller;

import org.manager.customer.controller.model.Customer;
import org.manager.customer.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService detailService;

	public CustomerController(CustomerService detailService) {
		this.detailService = detailService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id) {
		System.out.println("Calling with vale " + id);
		return new ResponseEntity<>(detailService.get(id), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> add(@RequestBody Customer detailModel) {
		System.out.println("Added " + detailModel.toString());
		return new ResponseEntity<>(detailService.add(detailModel) , HttpStatus.OK);
	}
}
