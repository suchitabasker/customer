package org.manager.customer.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USERDETAIL")
	@SequenceGenerator(name = "SEQ_USERDETAIL", sequenceName = "SEQ_USERDETAIL", allocationSize = 1)
	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity address;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<OrderEntity> orders = new ArrayList<>();

}
