package org.manager.customer.service.mapper;

import org.manager.customer.controller.model.Customer;
import org.manager.customer.controller.model.Orders;
import org.manager.customer.controller.model.Product;
import org.manager.customer.repository.entity.CustomerEntity;
import org.manager.customer.repository.entity.OrderEntity;
import org.manager.customer.repository.entity.ProductEntity;
import org.manager.customer.util.ConstantEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Qualifier(ConstantEnums.QLY_ORDERS)
public class OrderMapper implements Mapper<Orders, OrderEntity> {

	@Autowired
	@Qualifier(ConstantEnums.QLY_CUSTOMER)
	Mapper<Customer, CustomerEntity> customerMapper;

	@Autowired
	@Qualifier(ConstantEnums.QLY_PRODUCT)
	Mapper<Product, ProductEntity> productMapper;

	@Override
	public OrderEntity toEntity(Orders model) {
		OrderEntity entity = new OrderEntity();
		
		if (!ObjectUtils.isEmpty(model.getId()))
			entity.setId(model.getId());
		entity.setCustomer(customerMapper.toEntity(Customer.builder().id(model.getId()).build()));
		entity.setProduct(productMapper.toEntity(Product.builder().id(model.getId()).build()));
		return entity;
	}

	@Override
	public Orders toModel(OrderEntity entity) {
		
		Orders detail = Orders.builder()
				.id(entity.getId())
				.customer_id(entity.getCustomer().getId())
				.product_id(entity.getProduct().getId())
				.build();
		return detail;
	}

}
