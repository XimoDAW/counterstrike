package com.counterstrike.cs.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LevelValidator.class)
public @interface ValidLevel {
    String message() default "El nivel no puede ser negativo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
