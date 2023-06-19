package org.manager.customer.service;

import org.manager.customer.controller.model.Customer;

public interface CustomerService {

	Customer add(Customer detail);

	Customer get(Integer id);

	Customer update(Customer detail);

	boolean remove(Integer id);
}
