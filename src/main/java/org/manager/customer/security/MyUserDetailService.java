package org.manager.customer.security;

import java.util.Collections;

import org.manager.customer.repository.CustomerRepository;
import org.manager.customer.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerEntity customerEntity = customerRepository.findByUsername(username);
		return new User(customerEntity.getUsername(), customerEntity.getPassword(), Collections.EMPTY_LIST);
	}

	
}
