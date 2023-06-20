package org.manager.customer.data;

import java.math.BigDecimal;

import org.manager.customer.repository.CustomerRepository;
import org.manager.customer.repository.ProductRepository;
import org.manager.customer.repository.entity.AddressEntity;
import org.manager.customer.repository.entity.CustomerEntity;
import org.manager.customer.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSetup implements CommandLineRunner {

	@Autowired
	private final CustomerRepository customerRepository;

	@Autowired
	private final ProductRepository productRepository;
	
    @Autowired
    public DataSetup(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        // Perform data insertion here
    	addCustomer();
    	addProduct();
    }

	private void addCustomer() {
		CustomerEntity customerEntity = new CustomerEntity();
    	customerEntity.setFirstname("Basker");
    	customerEntity.setLastname("Nadar");
    	customerEntity.setUsername("basker");
    	customerEntity.setPassword("password");

    	AddressEntity addressEntity = new AddressEntity();
    	addressEntity.setAddress1("Mumbai");
    	addressEntity.setAddress2("Maharastra");
    	customerRepository.save(customerEntity);
	}

	private void addProduct() {
		ProductEntity entity = new ProductEntity();
		entity.setName("Car");
		entity.setPrice(new BigDecimal(100));
		productRepository.save(entity);

		ProductEntity entity1 = new ProductEntity();
		entity1.setName("Cycle");
		entity1.setPrice(new BigDecimal(100));
		productRepository.save(entity1);

	}
}
