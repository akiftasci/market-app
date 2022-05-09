package com.ing.appleMarket.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SupplierValidator.class)
@Documented
public @interface Supplier {
    String message() default "Supplier not valid";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

}
