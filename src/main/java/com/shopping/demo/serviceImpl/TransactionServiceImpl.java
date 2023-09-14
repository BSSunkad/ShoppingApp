package com.shopping.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.demo.exception.CustomerNotExistException;
import com.shopping.demo.repository.AccountRepository;
import com.shopping.demo.service.TransactionService;
import com.shopping.demo.util.CreditAmount;
import com.shopping.demo.util.DebitAmount;
import com.shopping.demo.util.TransactionValidation;
import com.shopping.demo.util.UsePoints;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private ProduceRepository produceRepository;
	
	@Autowired
	private TransactionValidation transactionValidation;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	// deposit
	@Override
	public void doDeposit(CreditAmount credit_amount) {
		boolean value = transactionValidation.validateCredit(credit_amount);
		if(value == true) {
			produceRepository.creditAmount(credit_amount);
		}
	}

	// debit or withdrawn
	@Override
	public void doDebit(DebitAmount debitAmount) {
		boolean value = transactionValidation.validateCredit(debitAmount);
		if(value == true) {
			produceRepository.debitAmount(debitAmount);
		}
	}

	@Override
	public void usePoints(UsePoints usePoints) {
		String accountId = accountRepository.findAccountByAccountNumber(usePoints);
		if(accountId.equals(usePoints.getAccountId())) {
			boolean value = transactionValidation.validatePoints(usePoints);
			if(value == true) {
				produceRepository.usePoints(usePoints);
			}else {
				throw new CustomerNotExistException();
			}
		}
	}

	
	@Override
	public String usePointsConvert(UsePoints usePoints) {
		String accountId = accountRepository.findAccountIdByAccountId(usePoints.getAccountId());
		if(accountId.equals(usePoints.getAccountId())) {
			boolean value = transactionValidation.validatePoints(usePoints);
			if(value == true) {
				String money = produceRepository.usePointsToMoney(usePoints);
				return money;
			}else {
				throw new NullPointerException();
			}
		}
		throw new CustomerNotExistException() ;
	}
}
