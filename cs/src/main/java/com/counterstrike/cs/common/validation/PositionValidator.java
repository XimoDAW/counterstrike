package com.counterstrike.cs.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositionValidator implements ConstraintValidator<ValidPosition, String> {

    @Override
    public void initialize(ValidPosition constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String position, ConstraintValidatorContext constraintValidatorContext) {
        return (position.equals("TERRORIST") || position.equals("COUNTER TERRORIST"));
    }
}
