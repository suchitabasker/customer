package org.manager.customer.controller.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Customer {

	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	private Address addresses;
}
