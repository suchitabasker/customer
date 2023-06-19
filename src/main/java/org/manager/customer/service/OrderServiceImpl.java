package org.manager.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.manager.customer.controller.model.Orders;
import org.manager.customer.controller.model.Product;
import org.manager.customer.exception.DetailNotFoundException;
import org.manager.customer.repository.CustomerRepository;
import org.manager.customer.repository.OrderRepository;
import org.manager.customer.repository.ProductRepository;
import org.manager.customer.repository.entity.OrderEntity;
import org.manager.customer.service.mapper.Mapper;
import org.manager.customer.util.ConstantEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	@Qualifier(ConstantEnums.QLY_ORDERS)
	Mapper<Orders, OrderEntity> mapper;

	@Override
	public Orders add(Orders detail) {

		final OrderEntity entity = new OrderEntity();
		entity.setCustomer(customerRepository.findById(detail.getCustomer_id()).get());
		entity.setProduct(productRepository.findById(detail.getProduct_id()).get());
		orderRepository.save(entity);
		return mapper.toModel(entity);
	}

	@Override
	public Orders get(Integer id) {
		final Optional<OrderEntity> entity = orderRepository.findById(id);
		if (entity.isEmpty()) {
			throw new DetailNotFoundException("Product detail not found.");
		}
		return mapper.toModel(entity.get());
	}

	@Override
	public Orders update(Orders detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Orders> getAllOrderForCustomer(Integer customerId) {
		final List<Orders> orders = new ArrayList<>();
		List<OrderEntity> entities = orderRepository.findByCustomerId(customerId);
		entities.forEach(entity -> orders.add(mapper.toModel(entity)));
		return orders;
	}

}
