package org.manager.customer.service.mapper;

import org.manager.customer.controller.model.Address;
import org.manager.customer.controller.model.Customer;
import org.manager.customer.repository.entity.AddressEntity;
import org.manager.customer.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Qualifier("customer")
public class CustomerMapper implements Mapper<Customer, CustomerEntity> {

	@Autowired
	@Qualifier("address")
	private Mapper<Address, AddressEntity> addressMapper;
	
	
	@Override
	public CustomerEntity toEntity(Customer model) {
		CustomerEntity entity = new CustomerEntity();
		
		if (!ObjectUtils.isEmpty(model.getId()))
			entity.setId(model.getId());
		
		entity.setFirstname(model.getFirstname());
		entity.setLastname(model.getLastname());
		entity.setUsername(model.getUsername());
		entity.setPassword(model.getPassword());
		entity.setAddress(addressMapper.toEntity(model.getAddresses()));
		return entity;
	}

	@Override
	public Customer toModel(CustomerEntity entity) {
		
		Customer detail = Customer.builder()
				.firstname(entity.getFirstname())
				.lastname(entity.getLastname())
				.username(entity.getUsername())
				.password(entity.getPassword())
				.id(entity.getId())
				.addresses(addressMapper.toModel(entity.getAddress()))
				.build();
				
		return detail;
	}

}
