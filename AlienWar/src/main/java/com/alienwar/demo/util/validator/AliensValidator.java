package com.alienwar.demo.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

/**
 * 
 * @author XQL
 * 敏感词验证
 *
 */
public class AliensValidator implements ConstraintValidator<Aliens, String> {

	@Override
	public void initialize(Aliens aliensValidator) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(value)) {
			return Boolean.TRUE;
		} else {
			return !StringUtils.trimAllWhitespace(value).equals("XQL");
		}
	}

}
