package com.example.employeetraining.service;

import com.example.employeetraining.model.entity.oauth.OAuthUser;
import com.example.employeetraining.model.request.EmailRegister;
import com.example.employeetraining.model.request.LoginRequest;
import com.example.employeetraining.model.request.RegisterRequest;
import com.example.employeetraining.model.request.ResetPasswordRequest;
import com.example.employeetraining.model.response.EmailResponse;
import com.example.employeetraining.model.response.LoginResponse;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

public interface UserService {
    OAuthUser register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    String sendEmailRegister(EmailRegister emailRegister);

    String validateToken(String token);

    OAuthUser findUserByOTP(String token);

    void saveUser(OAuthUser user);

    String sendEmailReset(EmailRegister emailRegister);

    String resetPassword(ResetPasswordRequest resetPasswordRequest);
    EmailResponse<?> repairGoogleSigninAction(MultiValueMap<String, String> params) throws IOException;
}
