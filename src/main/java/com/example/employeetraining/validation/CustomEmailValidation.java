package com.example.employeetraining.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomEmailValidator.class)
public @interface CustomEmailValidation {
    //error message
    String message() default "";
    //represents group of constraints
    Class<?>[] groups() default {};
    //represents additional information about annotation
    Class<? extends Payload>[] payload() default {};
}
