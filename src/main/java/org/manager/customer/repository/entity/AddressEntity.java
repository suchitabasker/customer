package org.manager.customer.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
    @SequenceGenerator(name = "SEQ_ADDRESS", sequenceName = "SEQ_ADDRESS", allocationSize = 1)
	private Integer id;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	
	@OneToOne(mappedBy = "address")
    private CustomerEntity customer;
	
}
