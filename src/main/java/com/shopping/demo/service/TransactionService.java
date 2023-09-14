package com.shopping.demo.service;

import com.shopping.demo.util.CreditAmount;
import com.shopping.demo.util.DebitAmount;
import com.shopping.demo.util.UsePoints;

public interface TransactionService {

	// deposit amount
	void doDeposit(CreditAmount credit_amount);
	
	// debit amount
	void doDebit(DebitAmount debitAmount);
	
	// use points 
	void usePoints(UsePoints usePoints);
	
	// convert points to money
	String usePointsConvert(UsePoints usePoints);
}
