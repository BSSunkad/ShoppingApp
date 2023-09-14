package com.shopping.demo.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_account")
public class CustomerAccount {
	
	@Id
	private String accountId ;
	private String customerId;
	private String account_number;
	private String account_type;
	private String accoubtBalance;
	private String totalPoint ;
	private LocalDateTime created_at ;

}
