package org.manager.customer.service;

import java.util.List;

import org.manager.customer.controller.model.Orders;

public interface OrderService {

	Orders add(Orders detail);

	Orders get(Integer id);

	Orders update(Orders detail);

	boolean remove(Integer id);

	List<Orders> getAllOrderForCustomer(Integer customerId);
}
