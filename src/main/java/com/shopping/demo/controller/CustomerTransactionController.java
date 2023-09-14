package com.shopping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.demo.service.TransactionService;
import com.shopping.demo.util.CreditAmount;
import com.shopping.demo.util.DebitAmount;

@RestController
@RequestMapping("/transaction")
public class CustomerTransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/diposit")
	public ResponseEntity<?> doDeposit(@RequestBody  CreditAmount credit_amount){
		transactionService.doDeposit(credit_amount);
		return new ResponseEntity<String>("Credited amount is :"+ credit_amount.getCreditAmount(),HttpStatus.OK);
	}
	
	@PostMapping("/debit")
	public ResponseEntity<?> doDebit(@RequestBody  DebitAmount debitAmount){
		transactionService.doDebit(debitAmount);
		return new ResponseEntity<String>("Debited amount is : "+ debitAmount.getDebitAmount(),HttpStatus.OK);
	}

}












