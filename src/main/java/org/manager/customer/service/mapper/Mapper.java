package org.manager.customer.service.mapper;

public interface Mapper<M, E> {

	E toEntity(M m);
	
	M toModel(E e);
	
}
