package com.example.employeetraining.util;


import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidationUtil {

    private final Validator validator;

    public void validate(Object obj) {
        var result = validator.validate(obj);

        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
    }
}
