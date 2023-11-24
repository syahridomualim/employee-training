package com.example.employeetraining.controller.auth;

import com.example.employeetraining.model.request.LoginRequest;
import com.example.employeetraining.model.response.EmailResponse;
import com.example.employeetraining.model.response.GeneralResponse;
import com.example.employeetraining.model.response.LoginResponse;
import com.example.employeetraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user-login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public GeneralResponse<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return new GeneralResponse<>(200, loginResponse, "sukses");
    }

    @PostMapping("/signin-google")
    @ResponseBody
    public EmailResponse<?> repairGoogleSignAction(@RequestParam MultiValueMap<String, String> params) throws IOException {
        return userService.repairGoogleSigninAction(params);
    }
}
