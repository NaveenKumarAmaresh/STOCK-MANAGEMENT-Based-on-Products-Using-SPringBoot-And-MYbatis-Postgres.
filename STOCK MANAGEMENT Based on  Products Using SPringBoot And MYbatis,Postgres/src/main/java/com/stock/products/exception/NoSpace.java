package com.stock.products.exception;

 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

 

@Target({ METHOD, FIELD,PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {SpaceValidation.class  })
public @interface NoSpace {
	 
	String message() default " White space is not accepted " ;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}