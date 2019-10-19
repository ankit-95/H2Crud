package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.h2.entity.Customer;
import com.h2.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		customer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCustomerById/{Id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("Id") Long Id) {

		Customer customer = customerService.findById(Id).get();
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {

		List<Customer> customers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteCustomerById/{Id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomerById(@PathVariable("Id") Long Id) {

		customerService.deleteCustomerById(Id);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);
	}
	
}
