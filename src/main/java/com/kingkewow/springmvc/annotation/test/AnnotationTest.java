package com.kingkewow.springmvc.annotation.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.kingkewow.springmvc.model.UserModel;

public class AnnotationTest {

	private static Validator validator;
	
	public static void main(String[] args) {
		UserModel model = new UserModel(null, "fang", 0, "jane");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		
		validator = factory.getValidator();
		
		Set<ConstraintViolation<UserModel>> constraintViolations = validator.validate(model);
		
		for(ConstraintViolation<UserModel> res : constraintViolations){
			System.err.println(res.getMessage());
			System.out.println(res.getPropertyPath());
			
		}
	}
	
}
