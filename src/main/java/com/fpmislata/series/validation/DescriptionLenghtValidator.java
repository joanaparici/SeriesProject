package com.fpmislata.series.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DescriptionLenghtValidator implements ConstraintValidator<DescriptionLenght, String> {

    public void initialize(DescriptionLenght constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.length() >= 10 && value.length() <= 100;
    }
}