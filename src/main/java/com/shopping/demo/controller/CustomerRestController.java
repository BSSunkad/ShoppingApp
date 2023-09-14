package com.shopping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.demo.dto.CustomerDto;
import com.shopping.demo.exception.IdAlreadyExistException;
import com.shopping.demo.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService custService;
	
	@GetMapping("/test")
	public ResponseEntity<String> testCustomerDto(){
		
		return new ResponseEntity<String>("Test is executed", HttpStatus.OK);		
	}
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> saveCustomerDto(@RequestBody CustomerDto customerDto) throws IdAlreadyExistException {
		CustomerDto save = custService.save(customerDto);
		return new ResponseEntity<CustomerDto>(save,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomer(){
		List<CustomerDto> getAllCustomers = custService.getAllCustomer();
		return new ResponseEntity<List<CustomerDto>>(getAllCustomers, HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerDto> getCustomer (@PathVariable("customerId")  String customerId){
		CustomerDto customerDto = custService.getCustomer(customerId);
		return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCustomer(CustomerDto customerDto, String customerId){
		 custService.updateCustomer(customerDto, customerId);
		
		return new ResponseEntity<String>("Customer Updated",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(String customerId){
		custService.deleteById(customerId);
		return new ResponseEntity<String>("Customer deleted", HttpStatus.GONE);
	}
}














