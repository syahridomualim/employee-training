package com.example.employeetraining.controller.auth;

import com.example.employeetraining.exception.NotMatchPasswordException;
import com.example.employeetraining.exception.UserAlreadyExistsException;
import com.example.employeetraining.exception.UserNotFoundException;
import com.example.employeetraining.model.entity.oauth.OAuthUser;
import com.example.employeetraining.model.request.EmailRegister;
import com.example.employeetraining.model.request.RegisterRequest;
import com.example.employeetraining.model.response.GeneralResponse;
import com.example.employeetraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user-register")
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @PostMapping("/register")
    public GeneralResponse<OAuthUser> saveRegisterManual(@Valid @RequestBody RegisterRequest registerRequest) throws UserAlreadyExistsException, NotMatchPasswordException, UserNotFoundException {
        OAuthUser oAuthUser = userService.register(registerRequest);
        sendEmailRegister(new EmailRegister(registerRequest.getEmail()));
        return new GeneralResponse<>(200, oAuthUser, "sukses");
    }

    @PostMapping("/send-otp")
    public GeneralResponse<String> sendEmailRegister(@Valid @RequestBody EmailRegister emailRegister) {
        String message = userService.sendEmailRegister(emailRegister);
        return new GeneralResponse<>(200, message, "sukses");
    }

    @GetMapping("/register-confirm-otp/{token}")
    public GeneralResponse<String> confirmOtp(@PathVariable("token") String token) {
        String message = userService.validateToken(token);
        return new GeneralResponse<>(200, message, "sukses");
    }
}
