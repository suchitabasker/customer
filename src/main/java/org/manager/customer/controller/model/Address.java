package org.manager.customer.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private Integer id;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
}
