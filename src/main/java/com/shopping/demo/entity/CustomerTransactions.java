package com.shopping.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "customer_transaction")
public class CustomerTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transaction_id;
	private String account_id;
	private String benificiary;
	private String benificiary_acc_no;
	private String debit_amount;
	private String credit_amount;
	private String totaoAmount;
	private String pointsFor_credit;
	private String totalPoints;
	private LocalDateTime created_at;

}
