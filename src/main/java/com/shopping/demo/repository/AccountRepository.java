package com.shopping.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.demo.entity.CustomerAccount;
import com.shopping.demo.util.UsePoints;

public interface AccountRepository extends JpaRepository<CustomerAccount, String> {
	
	@Query(value = "Select account_balance FROM customer_account WHERE account_number = :accountNo",nativeQuery = true)
	String findBalanceByAccountNumber(@Param("accountNo") String accountNo);
	
	@Query(value = "Select total_points FROM customer_account WHERE account_number = :accountNo",nativeQuery = true)
	String findPointsByAccountNumber(@Param("accountNo") String accountNo);

	@Query(value = "Select * FROM customer_account WHERE account_number = :accountNo",nativeQuery = true)
	CustomerAccount findAccountNumber(@Param("accountNo") String accountNo);
	
	@Query(value = "Select account_number FROM customer_account WHERE account_number = :accountNo",nativeQuery = true)
	String findAccountByAccountNumber(@Param("accountNo") UsePoints usePoints);
	
	@Query(value = "Select account_id FROM customer_acclount WHERE account_number = :accountNo",nativeQuery = true)
	String findAccountIdByAccountId(@Param("accountNo") String accountNo);

	CustomerAccount findByAccountNo(String accountNumber);

	String findAccountIdByAccountId(Object accountId);

	String findAccountByAccountNumber(String accountId);
	
}
