package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.dto.user.UserResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/user")
public class UserIdDuplicateController {

    @GetMapping("/register")
    public @ResponseBody UserResponseDto<?> idCheck(String userLoginId) {
        if(userLoginId == null || userLoginId.isEmpty()){
            return new UserResponseDto<>(-1,"아이디를 입력해주세요", null);
        }
        if(userLoginId.equals("test")){
            return new UserResponseDto<>(1,"동일한 아이디가 존재합니다", false);
        }else{
            return new UserResponseDto<>(1, "해당 아이디로 회원가입 가능합니다.", true);
        }
    }
}
