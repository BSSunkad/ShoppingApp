package com.shopping.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class CustomerDetails {
	
	private String customerId;
	private String name;
	private String email;
	private String phNo;
	private String dOB;
	private String customerType;
	private String rating;
	private String channelOfRegistration;
	private String date;
	private String token;
	private String flag;

}
