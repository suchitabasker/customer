package org.manager.customer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.manager.customer.CustomerApplicationTests;
import org.manager.customer.controller.model.Address;
import org.manager.customer.controller.model.Customer;
import org.manager.customer.repository.CustomerRepository;
import org.manager.customer.repository.entity.CustomerEntity;
import org.manager.customer.service.mapper.CustomerMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CustomerServiceImplTest extends CustomerApplicationTests{

	@Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void testAdd() {
        // Create a sample Customer model
    	 Address address1 = Address.builder()
         		.id(1)
         		.address1("Mumbai")
         		.build();
  
         Customer customer = Customer.builder()
         		.id(1)
         		.firstname("Basker")
         		.lastname("Nadar")
         		.addresses(address1)
         		.build();

        // Create a sample CustomerEntity
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1);
        customerEntity.setFirstname("Basker");
        customerEntity.setLastname("Nadar");

        // Configure the mock objects
        MockitoAnnotations.openMocks(this);
        Mockito.when(customerMapper.toEntity(customer)).thenReturn(customerEntity);
        Mockito.when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
        Mockito.when(customerMapper.toModel(customerEntity)).thenReturn(customer);

        // Call the add() method
        Customer result = customerService.add(customer);

        // Verify the result
        Assertions.assertEquals(customer.getId(), result.getId());
        Assertions.assertEquals(customer.getFirstname(), result.getFirstname());
        Assertions.assertEquals(customer.getLastname(), result.getLastname());
        Assertions.assertEquals(customer.getUsername(), result.getUsername());
        Assertions.assertEquals(customer.getPassword(), result.getPassword());

        // Verify the interactions with mock objects
        Mockito.verify(customerMapper, Mockito.times(1)).toEntity(customer);
        Mockito.verify(customerRepository, Mockito.times(1)).save(customerEntity);
        Mockito.verify(customerMapper, Mockito.times(1)).toModel(customerEntity);
    }
}
