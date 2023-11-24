package com.example.employeetraining.controller.auth;

import com.example.employeetraining.model.entity.oauth.OAuthUser;
import com.example.employeetraining.service.UserService;
import com.example.employeetraining.util.DateConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/web/user-register")
@Slf4j
@RequiredArgsConstructor
public class RegisterConfirm {

    private final UserService userService;
    private final DateConverter dateConverter;

    @GetMapping("/index/{otp}")
    public String index(Model model, @PathVariable("otp") String otp) {
        OAuthUser user = userService.findUserByOTP(otp);
        if (user == null) {
            log.warn("user not found");
            model.addAttribute("erordesc", String.format("User not found for code %s", otp));
            model.addAttribute("title", "");
            return "register";
        }

        String today = dateConverter.convertDateToString(new Date());
        String dateToken = dateConverter.convertDateToString(user.getOtpExpiredDate());
        if (Long.parseLong(today) > Long.parseLong(dateToken)) {
            model.addAttribute("erordesc", "Your token has been expired. Please get token again");
            model.addAttribute("title", "");
            return "register";
        }

        user.setEnabled(true);
        user.setOtp(null);
        userService.saveUser(user);
        model.addAttribute("title", String.format("Congratulations, %s, you have successfully registered", user.getFullName()));
        model.addAttribute("erordesc", "");
        return "register";
    }
}
