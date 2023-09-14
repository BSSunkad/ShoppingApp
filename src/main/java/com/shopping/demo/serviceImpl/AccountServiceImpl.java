package com.shopping.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cgs.loyalty.entity.customer.LoyaltyCustomerAccount;
import com.shopping.demo.advice.ErrorDetails;
import com.shopping.demo.dto.AccountDto;
import com.shopping.demo.dto.CustomerDto;
import com.shopping.demo.entity.CustomerAccount;
import com.shopping.demo.exception.BadRequestException;
import com.shopping.demo.exception.CustomerNotExistException;
import com.shopping.demo.exception.IdAlreadyExistException;
import com.shopping.demo.repository.AccountRepository;
import com.shopping.demo.repository.CustomerRepository;
import com.shopping.demo.service.AccountService;
import com.shopping.demo.util.AccountValidator;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountValidator accountValidator;
	
	// saving account by id
	@Override
	public AccountDto saveAccount(AccountDto accountDto) throws IdAlreadyExistException {
		
		String customerId = customerRepository.findCustomerById(accountDto.getCustomerId());
		if(customerId != null) {
			List<ErrorDetails> errors = accountValidator.validateToCreateAccountRequest(accountDto);
			if(errors.size()>0) {
				throw new BadRequestException(errors);
			}
			CustomerAccount account = dtoToCustomerAccount(accountDto);
			return CustomerAccountToDto(accountRepository.save(account));
		}else {
			throw new CustomerNotExistException();
		}
	}

	// checking points by account number
	@Override
	public String checkPoints(String accountNumber) {
		String accountNo = accountRepository.findPointsByAccountNumber(accountNumber);
		if(accountNo != null) {
			String points = accountRepository.findPointsByAccountNumber(accountNo);
			return points;
		}else {
			throw new CustomerNotExistException();
		}
	}

	
	// checking balance by account number
	@Override
	public String checkBalance(String accountNumber) {
		String accountNo = accountRepository.findBalanceByAccountNumber(accountNumber);
		if(accountNo != null) {
			String balance = accountRepository.findBalanceByAccountNumber(accountNo);
			return balance;
		}else {
			throw new CustomerNotExistException();
		}
	}

	// getting account by id
	@Override
	public AccountDto getAccountById(String accountId) {
		
		String accountNo = accountRepository.findAccountByAccountNumber(accountId);
		if(accountNo != null) {
			CustomerAccount customer = accountRepository.findAccountNumber(accountNo);
			return customerAccountToDto(customer);
		}else {
			throw new CustomerNotExistException();
		}
	}

	// deleting account by id
	@Override
	public void deleteByAccountNo(String accountNo) {
		String accountNo1 = accountRepository.findAccountByAccountNumber(accountNo);
		if(accountNo1 != null ) {
			accountRepository.deleteById(accountNo1);
		}else {
			throw new CustomerNotExistException();
		}
	}

//-------------------------------------------------	
	private CustomerAccount dtoToCustomerAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return null;
	}
	private AccountDto CustomerAccountToDto(CustomerAccount save) {
		// TODO Auto-generated method stub
		return null;
	}
	private AccountDto customerAccountToDto(CustomerAccount account) {
		// TODO Auto-generated method stub
		return null;
	}
}
