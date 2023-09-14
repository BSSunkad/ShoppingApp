package com.shopping.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.demo.advice.ErrorDetails;
import com.shopping.demo.dto.AccountDto;
import com.shopping.demo.entity.CustomerAccount;
import com.shopping.demo.exception.IdAlreadyExistException;
import com.shopping.demo.repository.AccountRepository;

public class AccountValidator {

	@Autowired
	private AccountRepository accountRepository;
	
	public List<ErrorDetails> validateToCreateAccountRequest(AccountDto accountDto) throws IdAlreadyExistException {
		Optional<CustomerAccount> account = accountRepository.findById(accountDto.getAccountId());
		
		if(account.isEmpty()) {
			String regxAccId = "^[\\d]{6}$";
			String regxCustomerId = "^[\\d]{4}$";
			String regxAccNo = "^[\\d]{8}$";
			
			boolean accId = accountDto.getAccountId().matches(regxAccId);
			boolean customerId = accountDto.getCustomerId().matches(regxCustomerId);
			boolean accNo = accountDto.getAccount_number().matches(regxAccNo);
			
			List<ErrorDetails> errors = new ArrayList<>();
			
			if(accId == false) {
				ErrorDetails error = new ErrorDetails("AccountId","account id must be 6 letters");
				errors.add(error);
			}
			
			if(customerId == false) {
				ErrorDetails error = new ErrorDetails("CustomerId", "customer id must be 4 letters");
				errors.add(error);
			}
			
			if(accNo == false) {
				ErrorDetails error = new ErrorDetails("AccountNo", "account number must be 8 letters");
				errors.add(error);
			}
			return errors;
		}else {
			throw new IdAlreadyExistException();
		}
	}
}
