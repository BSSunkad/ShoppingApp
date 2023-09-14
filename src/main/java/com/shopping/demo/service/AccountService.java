package com.shopping.demo.service;

import com.shopping.demo.dto.AccountDto;
import com.shopping.demo.exception.IdAlreadyExistException;

public interface AccountService {
	
	public AccountDto saveAccount(AccountDto accountDto) throws IdAlreadyExistException;
	
	public void deleteByAccountNo(String accountNo);
	
	public String checkPoints(String accountNumber);
	
	public String checkBalance(String accountNumber);
	
	public AccountDto getAccountById(String accountId);

	

}
