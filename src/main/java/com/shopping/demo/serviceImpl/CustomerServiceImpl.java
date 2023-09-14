package com.shopping.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.demo.advice.ErrorDetails;
import com.shopping.demo.dto.CustomerDto;
import com.shopping.demo.entity.CustomerDetails;
import com.shopping.demo.exception.BadRequestException;
import com.shopping.demo.exception.IdAlreadyExistException;
import com.shopping.demo.repository.CustomerRepository;
import com.shopping.demo.service.CustomerService;
import com.shopping.demo.util.CustomerValidator;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cusrtomerRepository;

	@Autowired
	private CustomerValidator customerValidator;

	// saving customer
	@Override
	public CustomerDto save(CustomerDto customerDto) throws IdAlreadyExistException {

		if (customerValidator.CheckIdExist(customerDto.getCustomerId())) {
			
			throw new IdAlreadyExistException();
		}
		List<ErrorDetails> errors = customerValidator.validateToCreateCustomer(customerDto);
		if (errors.size() > 0) {
			throw new BadRequestException(errors);
		}
		CustomerDetails customer = dtoToCustomerDetails(customerDto);
		CustomerDetails savedCustomer = cusrtomerRepository.save(customer);
		return customerDetailsToDto(savedCustomer);
	}

	
	// getting list of customers
	@Override
	public List<CustomerDto> getAllCustomer() {
		List<CustomerDetails> customers = customerValidator.checkListEmpty();
		List<CustomerDto> customerDtos = customers.stream().map(customer -> customerDetailsToDto(customer))
				.collect(Collectors.toList());
		return customerDtos;
	}

	
	// getting perticular customer
	@Override
	public CustomerDto getCustomer(String customerId) {
		CustomerDetails customer = customerValidator.checkCustomerPresentOrNot(customerId);
		return customerDetailsToDto(customer);
	}

	
	// updating customer or their details
	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, String customerId) {
		
		CustomerDetails presentOrNot = customerValidator.checkCustomerPresentOrNot(customerId);
		List<ErrorDetails> errors = customerValidator.validateToCreateCustomer(customerDto);
		if(errors.size()>0) {
			throw new BadRequestException(errors);
		}
		
		presentOrNot.setName(customerDto.getName());
		presentOrNot.setPhNo(customerDto.getPhNo());
		presentOrNot.setEmail(customerDto.getEmail());
		presentOrNot.setDOB(customerDto.getDOB());
		presentOrNot.setCustomerType(customerDto.getCustomerType());
		presentOrNot.setRating(customerDto.getRating());
		presentOrNot.setChannelOfRegistration(customerDto.getChannelOfRegistration());
		
		CustomerDetails present = cusrtomerRepository.save(presentOrNot);
		return customerDetailsToDto(present);
	}

	@Override
	public void deleteById(String customerId) {

		CustomerDetails customer = customerValidator.checkCustomerPresentOrNot(customerId);
		cusrtomerRepository.delete(customer);
	}

	//-------------------------------------
	
	private CustomerDto customerDetailsToDto(CustomerDetails savedCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	private CustomerDetails dtoToCustomerDetails(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
