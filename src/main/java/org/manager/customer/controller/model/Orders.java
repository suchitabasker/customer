package org.manager.customer.controller.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Orders {

	private Integer id;
	private Integer product_id;
	private Integer customer_id;
}
