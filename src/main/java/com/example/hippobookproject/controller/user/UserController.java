package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/phoneinfo")
    public String phoneInfo() {
        return "user/phoneinfo";
    }

    @GetMapping("/phoneinfocode")
    public String phoneInfoCode(){
        return "user/phoneinfocode";
    }

    @GetMapping("/idpassword")
    public String idPassword(){
        return "user/idpassword";
    }

    @GetMapping("/profilesetting")
    public String profileSetting(){
        return "user/profilesetting";
    }
}
