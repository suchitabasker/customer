package org.manager.customer.controller;

import java.util.List;

import org.manager.customer.controller.model.Product;
import org.manager.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		System.out.println("Calling with vale " + id);
		return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
	}
	
	@PostMapping("/product/add")
	public ResponseEntity<Product> add(@RequestBody Product product) {
		System.out.println("Added " + product.toString());
		return new ResponseEntity<>(productService.add(product) , HttpStatus.OK);
	}
}
