package com.example.employeetraining.validation;

import com.example.employeetraining.model.request.ResetPasswordRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, ResetPasswordRequest> {
    public boolean isValid(ResetPasswordRequest resetPasswordRequest, ConstraintValidatorContext c) {
        String plainPassword = resetPasswordRequest.getNewPassword();
        String repeatPassword = resetPasswordRequest.getConfirmPassword();

        if(plainPassword == null || !plainPassword.equals(repeatPassword)) {
            return false;
        }

        return true;
    }

}
