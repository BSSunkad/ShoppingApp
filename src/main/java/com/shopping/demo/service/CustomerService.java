package com.shopping.demo.service;

import java.util.List;

import com.shopping.demo.dto.CustomerDto;
import com.shopping.demo.exception.IdAlreadyExistException;

public interface CustomerService {

	
	//save customer
	public CustomerDto save(CustomerDto customerDto) throws IdAlreadyExistException;
	
	//get all customers
	public List<CustomerDto> getAllCustomer();
	
	//get a customer
	public CustomerDto getCustomer(String customerId);
	
	//update a customer
	public CustomerDto updateCustomer(CustomerDto customerDto, String customerId);
	
	//delete customer
	public void deleteById(String customerId);
}
