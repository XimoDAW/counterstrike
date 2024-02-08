package com.counterstrike.cs.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PositionValidator.class)

public @interface ValidPosition {
    String message() default "La posicion debe ser *TERRORIST* o *COUNTER TERRORIST*";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
