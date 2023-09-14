package com.shopping.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.demo.advice.ErrorDetails;
import com.shopping.demo.dto.PointsValueDto;
import com.shopping.demo.entity.PointsValues;
import com.shopping.demo.exception.IdAlreadyExistException;
import com.shopping.demo.repository.PointsRepository;

@Component
public class PointsValueValidation {

	@Autowired
	private PointsRepository pointsRepository;

	public List<ErrorDetails> validatePointsValues(PointsValueDto pointsValueDto) throws Exception {
		Optional<PointsValues> account = pointsRepository.findById(pointsValueDto.getId());

		if (account.isEmpty()) {
			List<ErrorDetails> errors = new ArrayList<>();

			if (pointsValueDto.getId().isEmpty() || pointsValueDto.getId().length() == 0) {
				ErrorDetails error = new ErrorDetails("valueId", "id should not be empty");
				errors.add(error);
			}

			if (pointsValueDto.getName().isEmpty() || pointsValueDto.getName().length() <= 3) {
				ErrorDetails error = new ErrorDetails("name", "Adder name should be atleast 4 letters");
				errors.add(error);
			}

			if (pointsValueDto.getBank_name().isEmpty() || pointsValueDto.getBank_name().length() <= 3) {
				ErrorDetails error = new ErrorDetails("Bank name", "Bnak name should be atleast 4 letters");
				errors.add(error);
			}

			if (pointsValueDto.getPoints_per_trans().isEmpty() || pointsValueDto.getPoints_per_trans() == null) {
				ErrorDetails error = new ErrorDetails("Points per Transaction", "It should not be empty or null");
				errors.add(error);
			}

			if (pointsValueDto.getPer_points().isEmpty() || pointsValueDto.getPer_points() == null) {
				ErrorDetails error = new ErrorDetails("Per points", "It should not be empty or null");
				errors.add(error);
			}

			if (pointsValueDto.getAmount().isEmpty() || pointsValueDto.getAmount() == null) {
				ErrorDetails error = new ErrorDetails("Amount", "amount should not empty or null");
				errors.add(error);
			}
			return errors;
		} else {
			throw new IdAlreadyExistException();
		}

	}

}
