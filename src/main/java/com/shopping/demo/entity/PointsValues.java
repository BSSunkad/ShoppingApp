package com.shopping.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "customer_points_value")
public class PointsValues {
	@Id
	private String id;
	private String name;
	private String bank_name;
	private String points_per_trans;
	private String per_points;
	private String amount;
	private LocalDateTime created_at; 
}
