package org.manager.customer.service;

import java.util.Optional;

import org.manager.customer.controller.model.Customer;
import org.manager.customer.exception.DetailNotFoundException;
import org.manager.customer.repository.CustomerRepository;
import org.manager.customer.repository.entity.CustomerEntity;
import org.manager.customer.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	@Qualifier("customer")
	Mapper<Customer, CustomerEntity> mapper;
	
	@Override
	public Customer add(final Customer detail) {
		CustomerEntity entity = customerRepository.save(mapper.toEntity(detail));
		return mapper.toModel(entity);
	}

	@Override
	public Customer get(Integer id) {
		Optional<CustomerEntity> entity = customerRepository.findById(id);
		if (entity.isEmpty()) 
			throw new DetailNotFoundException("Customer detail not found.");
		return mapper.toModel(entity.get());
	}

	@Override
	public Customer update(Customer detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


}
