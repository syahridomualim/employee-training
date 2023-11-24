package com.example.employeetraining.model.request;

import com.example.employeetraining.validation.CustomEmailValidation;
import com.example.employeetraining.validation.PasswordMatch;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class ResetPasswordRequest {

    @CustomEmailValidation(message = "please enter the correct email")
    private String email;
    private String newPassword = "";
    @NotNull(message = "token is required")
    private String otp;
    private String confirmPassword = "";
}
