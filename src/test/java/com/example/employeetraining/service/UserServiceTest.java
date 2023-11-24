package com.example.employeetraining.service;

import com.example.employeetraining.exception.NotMatchPasswordException;
import com.example.employeetraining.exception.UserAlreadyExistsException;
import com.example.employeetraining.model.entity.oauth.OAuthRole;
import com.example.employeetraining.model.entity.oauth.OAuthUser;
import com.example.employeetraining.model.request.RegisterRequest;
import com.example.employeetraining.repository.oauth.OAuthRoleRepository;
import com.example.employeetraining.repository.oauth.OAuthUserRepository;
import com.example.employeetraining.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private OAuthRoleRepository oAuthRoleRepository;

    @Mock
    private OAuthUserRepository oAuthUserRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testRegister_Success() throws NotMatchPasswordException, UserAlreadyExistsException {
        // Mocking input data
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("admin@mail.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");
        registerRequest.setFullName("Mualim Syahrido");

        // Mocking repository methods
        when(oAuthUserRepository.checkExistingEmail(anyString())).thenReturn(null);
        when(oAuthRoleRepository.findByNameIn(anyList())).thenReturn(Collections.singletonList(new OAuthRole()));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(oAuthUserRepository.save(any())).thenReturn(new OAuthUser());

        // Performing the actual test
        OAuthUser result = userService.register(registerRequest);

        // Assertions
        Assert.assertNotNull(result);
    }

    @Test(expected = NotMatchPasswordException.class)
    public void testRegister_PasswordMismatch() throws NotMatchPasswordException, UserAlreadyExistsException {
        // Mocking input data with mismatched passwords
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("admin@mail.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("mismatchedPassword");
        registerRequest.setFullName("Mualim Syahrido");

        // Performing the actual test, expect an exception
        userService.register(registerRequest);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testRegister_UserAlreadyExists() throws NotMatchPasswordException, UserAlreadyExistsException {
        // Mocking input data
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("admin@mail.com");
        registerRequest.setPassword("password");
        registerRequest.setConfirmPassword("password");
        registerRequest.setFullName("Mualim Syahrido");

        // Mocking repository method to return a user (simulating existing user)
        when(oAuthUserRepository.checkExistingEmail(anyString())).thenReturn(new OAuthUser());

        // Performing the actual test, expect an exception
        userService.register(registerRequest);
    }
}

