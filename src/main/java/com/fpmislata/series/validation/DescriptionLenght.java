package com.fpmislata.series.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DescriptionLenghtValidator.class)
public @interface DescriptionLenght {
    String message() default "La descripción debe tener entre 10 y 100 caracteres";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

