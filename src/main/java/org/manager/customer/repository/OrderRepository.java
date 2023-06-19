package org.manager.customer.repository;

import java.util.List;

import org.manager.customer.repository.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

	 List<OrderEntity> findByCustomerId(Integer customerId);
}
