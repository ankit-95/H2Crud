package com.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.entity.Customer;
import com.h2.repository.CustomerRepositroy;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepositroy customerRepositroy;
	
	public Customer saveCustomer(Customer c) {
		return customerRepositroy.save(c);
	}
	
	public Optional<Customer> findById(Long Id) {
		return customerRepositroy.findById(Id);
	}

	public List<Customer> getAllCustomers() {
		return customerRepositroy.findAll();
	}
	
	public void deleteCustomerById(Long Id) {
		customerRepositroy.deleteById(Id);
	}
}
