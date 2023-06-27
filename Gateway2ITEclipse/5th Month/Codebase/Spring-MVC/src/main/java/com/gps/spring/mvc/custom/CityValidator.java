package com.gps.spring.mvc.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * City Validator
 * 
 * @author GPS
 *
 */
public class CityValidator implements ConstraintValidator<IsValidCity, String> {

	@Override
	public void initialize(IsValidCity constraintAnnotation) {
	}

	@Override
	public boolean isValid(String cityValue, ConstraintValidatorContext context) {
		if(cityValue == null) {
			return false;
		} else if(cityValue.matches("Delhi|Noida|Gurgaon|Banglore|Mumbai")) {
			return true;
		} else {
			return false;
		}
	}
}
