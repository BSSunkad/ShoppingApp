package com.shopping.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.demo.advice.ErrorDetails;
import com.shopping.demo.dto.CustomerDto;
import com.shopping.demo.entity.CustomerDetails;
import com.shopping.demo.repository.CustomerRepository;

@Component
public class CustomerValidator {
	@Autowired
	CustomerRepository customerRepo;

	public boolean CheckIdExist(String id) {
		Optional<CustomerDetails> customer = customerRepo.findById(id);
		if (customer.isEmpty())
			return false;
		return true;
	}

	public List<ErrorDetails> validateToCreateCustomer(CustomerDto customerDto) {

		String regexId = "([0-9]{4})$";
		String regxEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String regxDOB = "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[012])\\1(?:19|20)\\d\\d$";
		String regxRating = "^([1-5])$";
		boolean id = customerDto.getCustomerId().matches(regexId);
		boolean email = customerDto.getEmail().matches(regxEmail);
		boolean dOB = customerDto.getDOB().matches(regxDOB);
		boolean rating = customerDto.getRating().matches(regxRating);

		List<ErrorDetails> errors = new ArrayList<>();

		// id
		if (id == false) {
			ErrorDetails error = new ErrorDetails("id", "Id should have 4 digits!");
			errors.add(error);
		}

		// name
		if (customerDto.getName().isEmpty() || customerDto.getName().length() == 0) {
			ErrorDetails error = new ErrorDetails("Name", "Name should be minimum 3 letters");
			errors.add(error);
		}

		// mobile
		if (customerDto.getPhNo().length() != 10) {
			ErrorDetails error = new ErrorDetails("Ph No", "PhNo should be 10 digits");
			errors.add(error);
		}

		// email
		if (email == false) {
			ErrorDetails error = new ErrorDetails("Email", "Email should be in format xyz@gmail.com");
			errors.add(error);
		}

		// DOB
		if (dOB == false) {
			ErrorDetails error = new ErrorDetails("Date Of Birth",
					"Date of Birth should be in the format of dd/mm/yyyyu");
			errors.add(error);
		}

		// customer type
		if (customerDto.getCustomerType().isEmpty() || customerDto.getCustomerType().length() == 0) {
			ErrorDetails error = new ErrorDetails("Customer type", "Customer type should not be emply");
			errors.add(error);
		}

		// rating
		if (rating == false) {
			ErrorDetails error = new ErrorDetails("Rating", "Rating must be in between 1-5");
			errors.add(error);
		}

		// channel of registration
		if (customerDto.getChannelOfRegistration().isEmpty() || customerDto.getChannelOfRegistration().length() == 0) {
			ErrorDetails error = new ErrorDetails("ChannelOfRegistration",
					"customer ChannelOfRegistration should not be empty");
			errors.add(error);
		}
		return errors;
	}

	public List<CustomerDetails> checkListEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDetails checkCustomerPresentOrNot(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
