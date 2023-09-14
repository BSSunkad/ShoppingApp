package com.shopping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.demo.dto.PointsValueDto;
import com.shopping.demo.service.PointsService;

@RestController
@RequestMapping(value = "/points")
public class CustomerPointsController {
	
	@Autowired
	private PointsService pointsService;
	
	@PostMapping("/setPointsValues")
	public ResponseEntity<PointsValueDto> savePointsData(@RequestBody PointsValueDto pointsValueDto){
		
		PointsValueDto savePointsData = pointsService.savePointsData(pointsValueDto);
		
		return new ResponseEntity<PointsValueDto>(savePointsData,HttpStatus.OK);
		
	}
}
