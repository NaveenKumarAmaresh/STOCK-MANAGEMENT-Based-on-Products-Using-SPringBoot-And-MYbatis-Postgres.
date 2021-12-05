package com.stock.products.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class SpaceValidation implements ConstraintValidator<NoSpace,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	   
		 return ((!value.equals(" "))
				 && value.trim().length() >0
				 && (value !=null)
				 &&(value.matches("^[a-zA-z]*$")));
	}
 
}
