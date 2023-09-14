package com.shopping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.demo.dto.AccountDto;
import com.shopping.demo.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class CustomerAccountController {

	
	@Autowired
	private AccountService accountService;
	
	// save account
	@PostMapping("/saveAccount")
	public ResponseEntity<String> saveAccount(@RequestBody AccountDto accountDto) throws Exception {
		((AccountService) accountDto).saveAccount(accountDto);
		String account_created = "account is created for "+accountDto.getAccountId()+" this customer id";
		return new ResponseEntity<String>(account_created,HttpStatus.CREATED);
	}
	
	// delete
	@DeleteMapping("/delete/{accountNo}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountNo") String accountNo){
		accountService.deleteByAccountNo(accountNo);
		String msg = accountNo+" : This accountNo is deleted";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/accountNo/{accountNo}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable("accountNo") String accountNo){
		AccountDto account = accountService.getAccountById(accountNo);
		return new ResponseEntity<AccountDto>(account,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/checkPoints/{accountNo}")
	public ResponseEntity<String> checkPointsByAccountNo(@PathVariable("accountNo")String accountNo){
		String points = accountService.checkPoints(accountNo);
		String msg = "Points at account are : "+points+" points";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/aceckBalance/{accountNo}")
	public ResponseEntity<String> CheckAccountBalanceByAccountNo(@PathVariable("accountNo") String accountNo){
		String balance = accountService.checkBalance(accountNo);
		String msg = "Balance of this Account is : "+balance;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
