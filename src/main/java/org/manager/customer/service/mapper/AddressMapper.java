package org.manager.customer.service.mapper;

import org.manager.customer.controller.model.Address;
import org.manager.customer.repository.entity.AddressEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@Qualifier("address")
public class AddressMapper implements Mapper<Address, AddressEntity> {

	@Override
	public AddressEntity toEntity(Address model) {
		AddressEntity entity = new AddressEntity();
		if (!ObjectUtils.isEmpty(model)) {

			if (!ObjectUtils.isEmpty(model.getId()))
				entity.setId(model.getId());

			entity.setAddress1(model.getAddress1());
			entity.setAddress2(model.getAddress2());
			entity.setAddress3(model.getAddress3());
			entity.setCity(model.getCity());
			entity.setState(model.getState());
		}

		return entity;
	}

	@Override
	public Address toModel(AddressEntity entity) {

		Address detail = Address.builder().address1(entity.getAddress1()).address2(entity.getAddress2())
				.address3(entity.getAddress3()).city(entity.getCity()).state(entity.getState()).id(entity.getId())
				.build();
		return detail;
	}

}
