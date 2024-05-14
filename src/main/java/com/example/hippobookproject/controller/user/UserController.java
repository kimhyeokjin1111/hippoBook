package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {

        return "user/login";
    }

    @PostMapping("/login")
    public String postLoginPage(String userLoginId, String userPassword, HttpSession session){
        try {
            Long userId = userService.findUserId(userLoginId, userPassword);
            session.setAttribute("userId", userId);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            return "user/login";
        }
        return "redirect:/";
    }

    @GetMapping("/terms-of-use")
    public String termsOfUse() {
        return "user/terms_of_use";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/register")
    public String postRegister(UserJoinDto userJoinDto){

        log.info("userJoinDto = {}",  userJoinDto);

        userService.joinUser(userJoinDto);

        return "redirect:/user/login";
    }

    @GetMapping("/find-account")
    public String findAccount(){
        return "user/find_account";
    }

    @GetMapping("/check-account")
    public String checkAccount() {
        return "user/check_account";
    }

    @GetMapping("/password-reset")
    public String passwordReset(){
        return "user/password_reset";
    }
}














