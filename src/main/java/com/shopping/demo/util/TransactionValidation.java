package com.shopping.demo.util;



public class TransactionValidation {

	public boolean validateCredit(CreditAmount credit_amount) {
		if(credit_amount.getAccountId().isEmpty() || credit_amount.getCreditAmount().isEmpty()) 
			throw new NullPointerException();
		else
			return true;
	}

	public boolean validateCredit(DebitAmount debitAmount) {
		if(debitAmount.getAccountId().isEmpty() || debitAmount.getDebitAmount().isEmpty()) 
			throw new NullPointerException();
		else
			return true;
	}

	public boolean validatePoints(UsePoints usePoints) {
		if(usePoints.getAccountId().isEmpty() || usePoints.getPoints().isEmpty())
			throw new NullPointerException();
			else
				return false;
	}

}
