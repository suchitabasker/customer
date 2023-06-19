package org.manager.customer.service;

import java.util.List;

import org.manager.customer.controller.model.Product;

public interface ProductService {

	Product add(Product detail);

	Product get(Integer id);

	Product update(Product detail);

	boolean remove(Integer id);
	
	List<Product> getAllProducts(); 

}
