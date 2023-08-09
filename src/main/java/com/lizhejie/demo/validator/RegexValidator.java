package com.lizhejie.demo.validator;

import com.lizhejie.demo.annotation.Regex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexValidator implements ConstraintValidator<Regex,String> {

    String regex = "";
    @Override
    public void initialize(Regex constraintAnnotation) {
       regex = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(regex);
    }

}
