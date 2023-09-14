package com.shopping.demo.dto;

import lombok.Data;

@Data
public class CustomerDto {

	private String customerId;
	private String name;
	private String email;
	private String phNo;
	private String dOB;
	private String customerType;
	private String rating;
	private String channelOfRegistration;
}
