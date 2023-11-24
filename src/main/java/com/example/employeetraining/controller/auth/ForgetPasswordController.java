package com.example.employeetraining.controller.auth;

import com.example.employeetraining.model.request.EmailRegister;
import com.example.employeetraining.model.request.ResetPasswordRequest;
import com.example.employeetraining.model.response.GeneralResponse;
import com.example.employeetraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/forget-password")
@RequiredArgsConstructor
public class ForgetPasswordController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/send")
    public GeneralResponse<String> sendEmailPassword(@Valid @RequestBody EmailRegister emailRegister) {
        String message = userService.sendEmailReset(emailRegister);
        return new GeneralResponse<>(200, message, "sukses");
    }

    @PostMapping("/validate")
    public GeneralResponse<String> checkTokenValid(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        userService.validateToken(resetPasswordRequest.getOtp());
        return new GeneralResponse<>(200, "success", "success");
    }

    @PostMapping("/change-password")
    public GeneralResponse<String> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        String message = userService.resetPassword(resetPasswordRequest);
        return new GeneralResponse<>(200, message, "sukses");
    }
}
