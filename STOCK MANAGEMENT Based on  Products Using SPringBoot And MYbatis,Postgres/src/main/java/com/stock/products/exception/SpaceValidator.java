package com.stock.products.exception;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.stock.products.model.Product;

public class SpaceValidator implements ConstraintValidator<NoSpace, Product> {

	@Override
	public boolean isValid(Product value, ConstraintValidatorContext context) {
		
		String a=value.getName();
		
		return a.matches("^[a-zA-z]*$")
				&&(!a.equals(" "))
				 && a.trim().length() >0
				 &&(a !=null);
	}
}
