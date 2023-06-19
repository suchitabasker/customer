package org.manager.customer.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "PRODUCT")
@Data
public class ProductEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
	private Integer id;
	private String name;
	
	@Column(precision = 10, scale = 2)
    private BigDecimal price;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();	
}
