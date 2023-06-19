package org.manager.customer.service.mapper;

import org.manager.customer.controller.model.Product;
import org.manager.customer.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Qualifier("product")
public class ProductMapper implements Mapper<Product, ProductEntity> {

	
	@Override
	public ProductEntity toEntity(Product model) {
		ProductEntity entity = new ProductEntity();
		
		if (!ObjectUtils.isEmpty(model.getId()))
			entity.setId(model.getId());
		
		entity.setName(model.getName());
		entity.setPrice(model.getPrice());
		return entity;
	}

	@Override
	public Product toModel(ProductEntity entity) {
		
		Product detail = Product.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.build();
				
		return detail;
	}

}
