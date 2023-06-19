package org.manager.customer.controller.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private Integer id;
	private String name;
	private BigDecimal price;
}
