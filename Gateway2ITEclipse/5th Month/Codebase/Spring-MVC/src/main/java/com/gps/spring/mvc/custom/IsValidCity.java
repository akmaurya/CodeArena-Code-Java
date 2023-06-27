package com.gps.spring.mvc.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation to validate city
 */
@Constraint(validatedBy = CityValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidCity {
	String message() default "Please provide a valid city;"
			+ " Allowed city are - Delhi, Noida,  Gurgaon, Banglore, Mumbai";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
