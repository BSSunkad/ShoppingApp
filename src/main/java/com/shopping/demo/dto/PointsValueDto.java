package com.shopping.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PointsValueDto {
	
	private String id;
	private String name;
	private String bank_name;
	private String points_per_trans;
	private String per_points;
	private String amount;
	private LocalDateTime created_at = LocalDateTime.now();

}
