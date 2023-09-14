package com.shopping.demo.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AccountDto {
	
	private String accountId;
	private String customerId;
	private String account_number;
	private String account_type;
	private String account_Balance="0";
	private String total_Points="0" ;
	private LocalDateTime created_at = LocalDateTime.now();

}
