package org.manager.customer.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.manager.customer.CustomerApplicationTests;
import org.manager.customer.controller.model.Address;
import org.manager.customer.controller.model.Customer;
import org.manager.customer.repository.entity.AddressEntity;
import org.manager.customer.repository.entity.CustomerEntity;
import org.manager.customer.util.ConstantEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class CustomerMapperTest extends CustomerApplicationTests {

	@Autowired
	@Qualifier(ConstantEnums.QLY_CUSTOMER)
    private Mapper<Customer, CustomerEntity> customerMapper;
    
	@Autowired
	@Qualifier(ConstantEnums.QLY_ADDRESS)
    private Mapper<Address, AddressEntity> addressMapper;

	@Test
    void testToEntity() {
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

        // Convert the Customer model to the CustomerEntity
        CustomerEntity entity = customerMapper.toEntity(customer);

        // Verify the fields of the CustomerEntity
        Assertions.assertEquals(1, entity.getId());
        Assertions.assertEquals("Basker", entity.getFirstname());
        Assertions.assertEquals("Nadar", entity.getLastname());

        // Verify the AddressEntities within the CustomerEntity
        Assertions.assertEquals("Mumbai", entity.getAddress().getAddress1());
    }
}
