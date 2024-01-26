package com.counterstrike.cs.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LevelValidator implements ConstraintValidator<ValidLevel, Integer>{
    @Override
    public void initialize(ValidLevel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer level, ConstraintValidatorContext constraintValidatorContext) {
        return (level >= 0);
    }
}
