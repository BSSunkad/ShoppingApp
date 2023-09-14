package com.shopping.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.shopping.demo.exception.BadRequestException;
import com.shopping.demo.exception.CustomerNotExistException;
import com.shopping.demo.exception.ListIsEmptyException;
import com.shopping.demo.exception.PointsNotAvailableException;
import com.student.demo.service.IdAlreadyExistException;

@ControllerAdvice
public class AExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<APIResponce> handledBadRequestException(BadRequestException e) {
		APIResponce apiResponce = new APIResponce();
		apiResponce.setStatus(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(400).body(apiResponce);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException) {
		return new ResponseEntity<String>("Input is null or Incorrect", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNotExistException.class)
	public ResponseEntity<String> handleCusromerNotExistException(CusromerNotExistException cusromerNotExistException) {
		return new ResponseEntity<String>("Given id is not presenr", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ListIsEmptyException.class)
	public ResponseEntity<String> handleListIsEmptyException(ListIsEmptyException listIsEmptyException) {
		return new ResponseEntity<String>("No data present on database", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<String>("Something went wromg pls check it", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdAlreadyExistException.class)
	public ResponseEntity<String> handleIdAlreadyExistException(IdAlreadyExistException idAlreadyExistException) {
		return new ResponseEntity<String>("Id Already Exist in database", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PointsNotAvailableException.class)
	public ResponseEntity<String> handlePointsNotAvailableException(
			PointsNotAvailableException pointsNotAvailableException) {
		return new ResponseEntity<String>("Your account does not have enough points", HttpStatus.BAD_REQUEST);
	}
}
