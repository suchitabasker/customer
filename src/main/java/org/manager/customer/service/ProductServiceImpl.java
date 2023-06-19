package org.manager.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.manager.customer.controller.model.Product;
import org.manager.customer.exception.DetailNotFoundException;
import org.manager.customer.repository.ProductRepository;
import org.manager.customer.repository.entity.ProductEntity;
import org.manager.customer.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	@Qualifier("product")
	Mapper<Product, ProductEntity> mapper;

	@Override
	public Product add(final Product detail) {
		final ProductEntity entity = productRepository.save(mapper.toEntity(detail));
		return mapper.toModel(entity);
	}

	@Override
	public Product get(final Integer id) {
		final Optional<ProductEntity> entity = productRepository.findById(id);
		if (entity.isEmpty()) {
			throw new DetailNotFoundException("Product detail not found.");
		}
		return mapper.toModel(entity.get());
	}

	@Override
	public Product update(final Product detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(final Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		final List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(entity -> products.add(mapper.toModel(entity)));
		return products;
	}
}
