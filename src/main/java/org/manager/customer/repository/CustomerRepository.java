package org.manager.customer.repository;

import org.manager.customer.repository.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

	CustomerEntity findByUsername(String username);
}
