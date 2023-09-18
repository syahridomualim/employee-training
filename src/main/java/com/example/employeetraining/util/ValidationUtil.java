package com.example.employeetraining.util;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidationUtil {
    final Validator validator;

    public void validate(Object obj) {
        var result = validator.validate(obj);

        if (!result.isEmpty()) {
            throw new ConstraintViolationException(result);
        }
    }
}
