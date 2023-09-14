package com.shopping.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDto {

	private String transaction_id;
	private String accountid;
	private String beneficiery;
	private String beneficiery_acc_no;
	private String depit_amount;
	private String credit_amount;
	private String totalAmount;
	private String pointsFor_credit;
	private String total_points;
	private LocalDateTime created_at;
}
