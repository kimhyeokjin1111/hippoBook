package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.dto.UserJoinDto;
import com.example.hippobookproject.dto.UserPhoneInfoDto;
import com.example.hippobookproject.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(HttpSession session){
        Long id = (Long) session.getAttribute("joinId");
        if (id != null) {
            return "redirect:/";
        }
        return "/user/login";
    }

    @GetMapping("/terms-of-use")
    public String termsOfUse() {
        return "user/terms_of_use";
    }

    @GetMapping("/phone-info")
    public String phoneInfo(UserPhoneInfoDto userPhoneInfoDto) {
        log.info("userPhoneInfoDto = {}", userPhoneInfoDto);

//        userService.phoneInfo(userPhoneInfoDto);

        return "user/phone_info";
    }

    @GetMapping("/phone-info-code")
    public String phoneInfoCode() {
        return "user/phone_info_code";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("/register")
    public String register(UserJoinDto userJoinDto, Model model){
        userService.joinUser(userJoinDto);
        return "/user/register";
    }

    @GetMapping("/profile-setting")
    public String profileSetting() {
        return "user/profile_setting";
    }

    @GetMapping("/find-phone-info")
    public String findAccountPhoneInfo(){
        return "user/find_phone_info";
    }

    @GetMapping("/find-phone-info-code")
    public String findAccountPhoneInfoCode() {
        return "user/find_phone_info_code";
    }

    @GetMapping("/check-account")
    public String checkAccount(){
        return "user/check_account";
    }

    @GetMapping("/password-reset")
    public String passwordReset(){
        return "user/password_reset";
    }
}
