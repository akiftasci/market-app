package com.ing.appleMarket.validator;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SupplierValidator implements ConstraintValidator<Supplier, String> {
    List<String> suppliers = Arrays.asList("Pink Lady", "Royal Gala", "Kanzi Apple", "Elstar Apples");

    @Override
    public boolean isValid(final String s, final ConstraintValidatorContext context) {
        return suppliers.stream().anyMatch(s::equalsIgnoreCase);
    }
}
