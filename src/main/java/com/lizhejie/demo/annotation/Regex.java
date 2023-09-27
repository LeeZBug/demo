package com.lizhejie.demo.annotation;

import com.lizhejie.demo.validator.RegexValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RegexValidator.class})
public @interface Regex {

    String value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "不符合给定的正则表达式";
}
